import { Component, OnInit, effect } from "@angular/core";
import { CompetenciesTableComponent } from "../competencies-table/competencies-table.component";
import { Wallet } from "../../types/Wallet.interface";
import { WalletService } from "../../services/wallet/wallet.service";
import { ActivatedRoute, Router } from "@angular/router";

@Component({
  selector: "app-wallet-page",
  standalone: true,
  imports: [CompetenciesTableComponent],
  templateUrl: "./wallet-page.component.html",
  styleUrl: "./wallet-page.component.css",
})
export class WalletPageComponent implements OnInit {
  wallet: Wallet | null = null;

  constructor(
    private walletService: WalletService,
    private route: ActivatedRoute,
    private router: Router,
  ) {
    effect(() => {
      const wallet = walletService.wallet()
      if (wallet !== null) return;
      this.wallet = wallet;
      console.log(this.wallet);
    });
  }

  async ngOnInit() {
    const walletID = this.route.snapshot.paramMap.get("id") || "";
    
    if (walletID === "") {
      console.log("redirecting to home");
      this.router.navigate(["home"]);
      return;
    }

    this.walletService.fetchWallet(walletID);
  }
}
