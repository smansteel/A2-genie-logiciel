import { Injectable } from "@angular/core";
import { User } from "../../types/User.type";
import { firstValueFrom } from "rxjs";
import { HttpClient } from "@angular/common/http";
import { AuthService } from "../../../auth/services/auth.service";

@Injectable({
  providedIn: "root",
})
export class UserService {
  private connectedUser: User | null = null;

  constructor(
    private http: HttpClient,
    private auth: AuthService,
  ) {
    this.fetchUser().then(user => {
      this.connectedUser = user;
    });
  }

  public get(): User {
    if (!this.connectedUser) {
      throw Error("User is not connected :/");
    }
    return this.connectedUser;
  }

  public async update(newUser: User): Promise<User> {
    if (!this.connectedUser) throw Error("User is not connected :/");

    const patchedUser = await firstValueFrom(this.http.patch<User>("user", { user: newUser }));

    if (patchedUser === newUser) {
      this.connectedUser = patchedUser;
      return patchedUser;
    }

    console.error("Failed to update user!", patchedUser);
    return this.connectedUser;
  }

  public async delete(): Promise<void> {
    if (!this.connectedUser) throw Error("User is not connected :/");

    await firstValueFrom(this.http.delete(`user/${this.connectedUser.id}`));
    this.auth.logout();
    this.connectedUser = null;
  }

  private async fetchUser(): Promise<User> {
    return await firstValueFrom(this.http.get<User>("user"));
  }

  public getFakeUserList() {
    const userList = [
      {
        id: 1,
        username: "jema00001",
        firstName: "Jean",
        name: "Martin",
      },
      {
        id: 2,
        username: "maco00002",
        firstName: "Marc",
        name: "Constant",
      },
      {
        id: 3,
        username: "luva00003",
        firstName: "Luc",
        name: "Varaut",
      },
      {
        id: 4,
        username: "addo00004",
        firstName: "Adrien",
        name: "D'Ormesson",
      },
      {
        id: 5,
        username: "jebo00005",
        firstName: "Jean-Philippe",
        name: "Bottéro",
      },
    ];

    const randomTimeout = Math.floor(Math.random() * (400 - 200 + 1)) + 400;
    return new Promise(resolve => {
      setTimeout(() => {
        resolve(userList);
      }, randomTimeout);
    });
  }
}
