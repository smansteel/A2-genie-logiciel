import { Component, OnInit, effect } from "@angular/core";
import { CompetenciesTableComponent } from "../competencies-table/competencies-table.component";
import { Wallet } from "../../types/Wallet.interface";
import { WalletService } from "../../services/wallet/wallet.service";
import { ActivatedRoute, Router } from "@angular/router";
import { LoadingTableComponent } from "../loading-table/loading-table.component";

@Component({
  selector: "app-wallet-page",
  standalone: true,
  imports: [CompetenciesTableComponent, LoadingTableComponent],
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
      if (walletService.wallet() === null) return;

      this.wallet = walletService.wallet();
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
