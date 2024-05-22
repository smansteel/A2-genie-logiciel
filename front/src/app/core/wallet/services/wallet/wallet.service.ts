import { Injectable, WritableSignal, signal } from "@angular/core";
import { Wallet } from "../../types/Wallet.interface";
import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { ActivatedRoute, Router } from "@angular/router";
import { firstValueFrom } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class WalletService {
  public wallet: WritableSignal<Wallet | null> = signal(null);

  constructor(
    private http: HttpClient,
    private route: ActivatedRoute,
    private router: Router,
  ) {
    this.getWalletID().then(walletID => {
      if (walletID === "") {
        this.router.navigate(["home"]);
        return;
      }

      this.fetchWallet(walletID).then(wallet => {
        this.wallet.set(wallet);
      });
    });
  }

  private async getWalletID(): Promise<string> {
    return (await firstValueFrom(this.route.paramMap)).get("id") || "";
  }

  private async fetchWallet(walletID: string): Promise<Wallet> {
    try {
      return await firstValueFrom(this.http.get<Wallet>("wallet/" + walletID));
    } catch (error) {
      throw new HttpErrorResponse({ statusText: "Failed to fetch wallet", error: error });
    }
  }

  public async editWallet(wallet: Wallet): Promise<Wallet> {
    try {
      return await firstValueFrom(this.http.patch<Wallet>("wallet/" + wallet.id, wallet));
    } catch (error) {
      throw new HttpErrorResponse({ statusText: "Failed to edit wallet", error: error });
    }
  }

  public async deleteWallet(walletID: string) {
    try {
      return await firstValueFrom(this.http.delete<Wallet>("wallet/" + walletID));
    } catch (error) {
      throw new HttpErrorResponse({ statusText: "Failed to delete wallet", error: error });
    }
  }
}
