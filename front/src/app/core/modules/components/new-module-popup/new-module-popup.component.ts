import { Component, Inject } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { MAT_DIALOG_DATA, MatDialogClose, MatDialogRef } from "@angular/material/dialog";
import { Module } from "../../../../shared/types/Module.type";

@Component({
  selector: "app-new-module-popup",
  standalone: true,
  imports: [FormsModule, MatDialogClose],
  templateUrl: "./new-module-popup.component.html",
  styleUrl: "./new-module-popup.component.css",
})
export class NewModulePopupComponent {
  constructor(
    public dialog: MatDialogRef<NewModulePopupComponent>,
    @Inject(MAT_DIALOG_DATA) public module: Module,
  ) {}

  closeDialog() {
    this.dialog.close();
  }
}
