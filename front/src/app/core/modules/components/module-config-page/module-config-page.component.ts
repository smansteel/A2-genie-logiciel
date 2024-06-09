import { Component } from "@angular/core";
import { NgForOf, NgIf } from "@angular/common";
import { IsepModule } from "../../../../shared/types/IsepModule.type";
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
  modules: IsepModule[] = [];

  constructor(
    private dialog: MatDialog,
    private moduleService: ModuleService,
    private router: Router,
  ) {
    this.fetchModules().then(() => {
      console.log("Modules fetched");
    });
  }

  async fetchModules() {
    const modules = await this.moduleService.fetchModules();
    if (modules) {
      this.modules.push(...modules);
    }
  }

  onNewModuleClk() {
    const dia = this.dialog.open(NewModulePopupComponent);

    dia.afterClosed().subscribe(result => {
      if (result.name && result.description) {
        const newModule: IsepModule = {
          id: (this.modules.length + 1).toString(),
          name: result.name,
          description: result.description,
          wallets: [],
        };
        this.moduleService.addModule(newModule).then(() => {
          console.log("Module succesfully added");
          this.modules.push(newModule);
        });
      }
    });
  }

  viewModule(id: string | undefined) {
    if (id) {
      this.router.navigate(["/admin/module/" + id]);
    }
  }
}
