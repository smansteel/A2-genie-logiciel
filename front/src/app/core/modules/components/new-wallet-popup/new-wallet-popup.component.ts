import { Component } from "@angular/core";
import { MatDialogClose, MatDialogRef } from "@angular/material/dialog";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";

@Component({
  selector: "app-new-wallet-popup",
  standalone: true,
  imports: [ReactiveFormsModule, FormsModule, MatDialogClose],
  templateUrl: "./new-wallet-popup.component.html",
  styleUrl: "./new-wallet-popup.component.css",
})
export class NewWalletPopupComponent {
  constructor(public dialog: MatDialogRef<NewWalletPopupComponent>) {}

  closeDialog() {
    this.dialog.close();
  }
}
