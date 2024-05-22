import { Component, effect } from "@angular/core";
import { CompetenciesTableComponent } from "../competencies-table/competencies-table.component";
import { Wallet } from "../../types/Wallet.interface";
import { WalletService } from "../../services/wallet/wallet.service";

@Component({
  selector: "app-wallet-page",
  standalone: true,
  imports: [CompetenciesTableComponent],
  templateUrl: "./wallet-page.component.html",
  styleUrl: "./wallet-page.component.css",
})
export class WalletPageComponent {
  wallet: Wallet | null = this.walletService.wallet();

  constructor(private walletService: WalletService) {
    effect(() => {
      if (walletService.wallet !== null) return;
      this.wallet = this.walletService.wallet();
    });
  }
}
