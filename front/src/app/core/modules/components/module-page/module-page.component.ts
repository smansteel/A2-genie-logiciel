import { Component } from "@angular/core";
import { IsepModule } from "../../../../shared/types/IsepModule.type";
import { ModuleService } from "../../services/module-service/module.service";
import { NgForOf, NgIf } from "@angular/common";
import { MatDialog } from "@angular/material/dialog";
import { NewWalletPopupComponent } from "../new-wallet-popup/new-wallet-popup.component";
import { Router } from "@angular/router";
import { SearchUserPopupComponent } from "../search-user-popup/search-user-popup.component";

@Component({
  selector: "app-module-page",
  standalone: true,
  imports: [NgForOf, NgIf],
  templateUrl: "./module-page.component.html",
  styleUrl: "./module-page.component.css",
})
export class ModulePageComponent {
  module: IsepModule;

  constructor(
    private moduleService: ModuleService,
    private dialog: MatDialog,
    private router: Router,
  ) {
    this.module = this.moduleService.getEmptyModule();
    this.moduleService.fetchModule("1").then(r => {
      this.module = r;
    });
  }

  onNewWalletClk() {
    const dia = this.dialog.open(NewWalletPopupComponent);

    dia.afterClosed().subscribe(result => {
      if (result.name && result.description) {
        this.module.wallets.push({
          id: this.module.wallets.length + 1,
          name: result.name,
          description: result.description,
          authorizedEditorsID: [],
          competencies: [],
        });
      }
    });
  }

  viewWallet(id: number) {
    if (id) {
      this.router.navigate(["/wallet/" + id]);
    }
  }

  selectModuleEditor() {
    const dia = this.dialog.open(SearchUserPopupComponent);

    dia.afterClosed().subscribe(result => {
      if (result) {
        this.module.responsable = {
          isepId: result.username,
          id: result.id,
          name: result.name,
          firstName: result.firstName,
        };
      }
    });
  }
}
