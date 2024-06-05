import { Injectable, signal, WritableSignal } from "@angular/core";

import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { firstValueFrom } from "rxjs";
import { Module } from "../../../../shared/types/Module.type";

@Injectable({
  providedIn: "root",
})
export class ModuleService {
  public module: WritableSignal<Module | null> = signal(null);

  constructor(private http: HttpClient) {}

  public async fetchModule(moduleID: string): Promise<Module> {
    const module: Module = await this.getFakeModule();
    this.module.set(module);
    return module;

    try {
      const module = await firstValueFrom(this.http.get<Module>("module/" + moduleID));
      this.module.set(module);
      return module;
    } catch (error) {
      throw new HttpErrorResponse({ statusText: "Failed to fetch module", error: error });
    }
  }

  public async addModule(module: Module): Promise<Module> {
    try {
      return await firstValueFrom(this.http.put<Module>("module/" + module.id, module));
    } catch (error) {
      throw new HttpErrorResponse({ statusText: "Failed to edit module", error: error });
    }
  }

  public async editModule(module: Module): Promise<Module> {
    try {
      return await firstValueFrom(this.http.patch<Module>("module/" + module.id, module));
    } catch (error) {
      throw new HttpErrorResponse({ statusText: "Failed to edit module", error: error });
    }
  }

  public async deleteModule(moduleID: string) {
    try {
      return await firstValueFrom(this.http.delete<Module>("module/" + moduleID));
    } catch (error) {
      throw new HttpErrorResponse({ statusText: "Failed to delete module", error: error });
    }
  }

  private async getFakeModule() {
    return { id: 1, name: "Test module", description: "Test short description" };
  }
}
