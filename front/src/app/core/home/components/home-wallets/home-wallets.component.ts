import { Component, effect } from "@angular/core";
import { WalletPreview } from "../../types/WalletPreview.type";
import { WalletPreviewService } from "../../services/wallet-preview/wallet-preview.service";
import { CommonModule } from "@angular/common";
import { Router } from "@angular/router";

@Component({
  selector: "app-home-wallets",
  standalone: true,
  imports: [CommonModule],
  templateUrl: "./home-wallets.component.html",
  styleUrl: "./home-wallets.component.css",
})
export class HomeWalletsComponent {
  wallets: WalletPreview[] = [];

  constructor(
    private walletPreviewService: WalletPreviewService,
    private router: Router,
  ) {
    effect(() => {
      this.wallets = this.walletPreviewService.walletPreviews();
    });
  }

  openWallet(walletId: number) {
    this.router.navigate(["/wallet/" + walletId]);
  }
}
