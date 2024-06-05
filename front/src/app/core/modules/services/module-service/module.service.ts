import { Injectable, signal, WritableSignal } from "@angular/core";

import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { firstValueFrom } from "rxjs";
import { IsepModule } from "../../../../shared/types/IsepModule.type";

@Injectable({
  providedIn: "root",
})
export class ModuleService {
  public module: WritableSignal<IsepModule | null> = signal(null);

  constructor(private http: HttpClient) {}

  public async fetchModule(moduleID: string): Promise<IsepModule> {
    const module: IsepModule = await this.getFakeModule();
    this.module.set(module);
    return module;

    try {
      const module = await firstValueFrom(this.http.get<IsepModule>("module/" + moduleID));
      this.module.set(module);
      return module;
    } catch (error) {
      throw new HttpErrorResponse({ statusText: "Failed to fetch module", error: error });
    }
  }

  public async addModule(module: IsepModule): Promise<IsepModule> {
    try {
      return await firstValueFrom(this.http.put<IsepModule>("module/" + module.id, module));
    } catch (error) {
      throw new HttpErrorResponse({ statusText: "Failed to edit module", error: error });
    }
  }

  public async editModule(module: IsepModule): Promise<IsepModule> {
    try {
      return await firstValueFrom(this.http.patch<IsepModule>("module/" + module.id, module));
    } catch (error) {
      throw new HttpErrorResponse({ statusText: "Failed to edit module", error: error });
    }
  }

  public async deleteModule(moduleID: string) {
    try {
      return await firstValueFrom(this.http.delete<IsepModule>("module/" + moduleID));
    } catch (error) {
      throw new HttpErrorResponse({ statusText: "Failed to delete module", error: error });
    }
  }

  private async getFakeModule() {
    return {
      id: "1",
      name: "Test module",
      description: "Test short description",
      responsable: undefined,
      wallets: [],
    } as IsepModule;
  }

  getEmptyModule() {
    return {
      id: "XXX",
      name: "XXX",
      description: "XXX",
      responsable: undefined,
      wallets: [],
    } as IsepModule;
  }
}
