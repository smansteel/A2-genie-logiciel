import { Component } from "@angular/core";
import { Wallet } from "../../../wallet/types/Wallet.interface";
import { WalletPreview } from "../../types/WalletPreview.type";

@Component({
  selector: "app-home-wallets",
  standalone: true,
  imports: [],
  templateUrl: "./home-wallets.component.html",
  styleUrl: "./home-wallets.component.css",
})
export class HomeWalletsComponent {
  wallets: WalletPreview[] = [];
}
