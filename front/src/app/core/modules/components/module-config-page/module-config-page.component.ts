import { Component } from "@angular/core";
import { NgForOf, NgIf } from "@angular/common";
import { Module } from "../../../../shared/types/Module.type";
import { NewModulePopupComponent } from "../new-module-popup/new-module-popup.component";
import { MatDialog } from "@angular/material/dialog";
import { ModuleService } from "../../services/module-service/module.service";
import { Router } from "@angular/router";

@Component({
  selector: "app-module-config-page",
  standalone: true,
  imports: [NgForOf, NgIf],
  templateUrl: "./module-config-page.component.html",
  styleUrl: "./module-config-page.component.css",
})
export class ModuleConfigPageComponent {
  modules: Module[] = [];
  newModule: Module = {};

  constructor(
    private dialog: MatDialog,
    private moduleService: ModuleService,
    private router: Router,
  ) {
    this.moduleService.fetchModule("1").then(r => {
      this.modules.push(r);
    });
  }

  onNewModuleClk() {
    const dia = this.dialog.open(NewModulePopupComponent, {
      data: { module: this.newModule },
    });

    dia.afterClosed().subscribe(result => {
      console.log("The dialog was closed");
      this.newModule = result;
      if (this.newModule.name && this.newModule.description) {
        this.modules.push(this.newModule);
        this.newModule = {};
      }
    });
  }

  viewModule(id: number | undefined) {
    this.router.navigate(["/admin/module/" + id]);
  }
}
