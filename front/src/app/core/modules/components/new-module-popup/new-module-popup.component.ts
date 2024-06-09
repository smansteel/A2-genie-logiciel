import { Component } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { MatDialogClose, MatDialogRef } from "@angular/material/dialog";

@Component({
  selector: "app-new-module-popup",
  standalone: true,
  imports: [FormsModule, MatDialogClose],
  templateUrl: "./new-module-popup.component.html",
  styleUrl: "./new-module-popup.component.css",
})
export class NewModulePopupComponent {
  constructor(public dialog: MatDialogRef<NewModulePopupComponent>) {}
}
