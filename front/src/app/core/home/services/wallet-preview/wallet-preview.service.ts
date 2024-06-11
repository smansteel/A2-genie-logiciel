import { Injectable, WritableSignal, signal } from "@angular/core";
import { WalletPreview } from "../../types/WalletPreview.type";
import { firstValueFrom } from "rxjs";
import { HttpClient, HttpErrorResponse } from "@angular/common/http";

@Injectable({
  providedIn: "root",
})
export class WalletPreviewService {
  walletPreviews: WritableSignal<WalletPreview[]> = signal([]);

  constructor(private http: HttpClient) {
    this.getFakeWallet().then(wallets => {
      this.walletPreviews.set(wallets);
    });
  }

  async fetchWallets() {
    try {
      const wallets = await firstValueFrom(this.http.get<WalletPreview[]>("walletPreviews/"));
      this.walletPreviews.set(wallets);
      return wallets;
    } catch (error) {
      throw new HttpErrorResponse({ statusText: "Failed to fetch wallet", error: error });
    }
  }

  private getFakeWallet(): Promise<WalletPreview[]> {
    const wallets: WalletPreview[] = [
      {
        walletId: 1,
        title: "APP A1",
        responsable: "Zakia Kazi",
      },
      {
        walletId: 2,
        title: "Génie Logiciel",
        responsable: "Zakia Kazi",
      },
    ];

    const randomTimeout = Math.floor(Math.random() * (400 - 200 + 1)) + 200;
    return new Promise(resolve => {
      setTimeout(() => {
        resolve(wallets);
      }, randomTimeout);
    });
  }
}
