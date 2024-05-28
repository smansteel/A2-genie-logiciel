import { Injectable, OnInit, WritableSignal, signal } from "@angular/core";
import { Wallet } from "../../types/Wallet.interface";
import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { ActivatedRoute, Router } from "@angular/router";
import { firstValueFrom, lastValueFrom } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class WalletService {
  public wallet: WritableSignal<Wallet | null> = signal(null);

  constructor(private http: HttpClient) {}

  public async fetchWallet(walletID: string): Promise<Wallet> {
    const wallet = await this.getFakeWallet();
    this.wallet.set(wallet);
    console.log("here");
    return wallet;

    try {
      const wallet = await firstValueFrom(this.http.get<Wallet>("wallet/" + walletID));
      this.wallet.set(wallet);
      return wallet;
    } catch (error) {
      throw new HttpErrorResponse({ statusText: "Failed to fetch wallet", error: error });
    }
  }

  public async editWallet(wallet: Wallet): Promise<Wallet> {
    try {
      return await firstValueFrom(this.http.patch<Wallet>("wallet/" + wallet.id, wallet));
    } catch (error) {
      throw new HttpErrorResponse({ statusText: "Failed to edit wallet", error: error });
    }
  }

  public async deleteWallet(walletID: string) {
    try {
      return await firstValueFrom(this.http.delete<Wallet>("wallet/" + walletID));
    } catch (error) {
      throw new HttpErrorResponse({ statusText: "Failed to delete wallet", error: error });
    }
  }

  private getFakeWallet(): Promise<Wallet> {
    const wallet: Wallet = {
      id: 1,
      name: "APP A1",
      description: "Projets de Groupe pour les A1, regroupant : Electronike, Signal, Web et intégration ",
      authorizedEditorsID: [1, 2, 3],
      competencies: [
        {
          id: 1,
          name: "Electronique",
          description: "Réaliser un sonomètre et plus encore ",
          subCompetencies: [
            {
              id: 1,
              name: "Fonctionnement d'un microcontrôleur",
              description: "Comprendre le fonctionnement d'un microcontrôleur",
              skill: null,
            },
            {
              id: 2,
              name: "Utilisation d'un multimètre",
              description: "Savoir utiliser un multimètre",
              skill: null,
            },
            {
              id: 3,
              name: "Réalisation d'un circuit imprimé",
              description: "Savoir réaliser un circuit imprimé",
              skill: null,
            },
            {
              id: 4,
              name: "Organisation d'un projet",
              description: "Savoir organiser un projet",
              skill: null,
            },
            {
              id: 5,
              name: "Soutenances",
              description: "Savoir présenter et vendre un projet",
              skill: null,
            },
          ],
        },
        {
          id: 2,
          name: "Signal",
          description: "Faire du Matlab et du traitement de signal",
          subCompetencies: [
            {
              id: 1,
              name: "Algo de détéction de bruit",
              description: "Savoir réaliser un algorithme de détection de bruit sur Matlab",
              skill: null,
            },
            {
              id: 2,
              name: "Traitement de signal",
              description: "Savoir traiter un signal",
              skill: null,
            },
            {
              id: 3,
              name: "Algorithme de détection de la voix",
              description: "Savoir réaliser un algorithme de détection de la voix",
              skill: null,
            },
            {
              id: 4,
              name: "Livrables",
              description: "Évaluation des rendus",
              skill: null,
            },
          ],
        },
        {
          id: 3,
          name: "Web",
          description: "Réaliser un site web en html, css, js et php",
          subCompetencies: [
            {
              id: 1,
              name: "Pages statiques",
              description: "Réaliser les page de base d'un site web",
              skill: null,
            },
            {
              id: 2,
              name: "Pages dynamiques",
              description: "Réaliser des pages dynamiques",
              skill: null,
            },
            {
              id: 3,
              name: "Base de données",
              description: "Savoir utiliser une base de données",
              skill: null,
            },
            {
              id: 4,
              name: "Sécurité",
              description: "Savoir sécuriser un site web et se protéger des attaques",
              skill: null,
            },
            {
              id: 5,
              name: "Backend",
              description: "Savoir réaliser un backend en php",
              skill: null,
            },
            {
              id: 6,
              name: "Passerelle",
              description: "Savoir réaliser une passerelle entre le backend et le serveur de l'ISEP",
              skill: null,
            },
            {
              id: 7,
              name: "Livrables",
              description: "Évaluation des rendus",
              skill: null,
            },
          ],
        },
        {
          id: 4,
          name: "Intégration",
          description: "Intégrer le projet éléctronique, signal et web",
          subCompetencies: [
            {
              id: 1,
              name: "Algorithms en C",
              description: "Intégrer les algo de signal en C sur la carte TIVA",
              skill: null,
            },
            {
              id: 2,
              name: "Passerelle",
              description: "Faire communiquer la carte TIVA et le site web",
              skill: null,
            },
            {
              id: 3,
              name: "Livrables",
              description: "Évaluation des rendus",
              skill: null,
            },
          ],
        },
      ],
    };

    const randomTimeout = Math.floor(Math.random() * (400 - 200 + 1)) + 200;
    return new Promise(resolve => {
      setTimeout(() => {
        resolve(wallet);
      }, randomTimeout);
    });
  }
}
