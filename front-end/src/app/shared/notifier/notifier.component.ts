import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { NotifierService } from './notifier.service';

@Component({
  selector: 'app-notifier',
  standalone: true,
  imports: [],
  templateUrl: './notifier.component.html',
  styleUrl: './notifier.component.css'
})
export class NotifierComponent implements OnInit, OnDestroy {
  private subscription!: Subscription;
  protected msg: string | undefined;

  private alertCount = 0; // Contador de alertas
  private zIndex = 1000;  // Valor inicial de z-index

  constructor(private notifierService: NotifierService) { }

  ngOnInit(): void {
    this.subscription = this.notifierService.notifier$.subscribe((msg) => {
      this.handleNotification(msg);
    });
  }

  private handleNotification(msg: string) {
    this.msg = msg;
    setTimeout(() => {
      setTimeout(() => {
        this.msg = undefined;
      }, 500); // Tempo da animação fade-out
    }, 2000); // Popup aparece por 2 segundos

  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }



  // Função para criar um novo popup
  showPopup(message: string) {
    this.alertCount++; // Incrementa o número do alerta

    // Cria o elemento do popup dinamicamente
    const popup = document.createElement("div");
    popup.classList.add("popup");
    popup.textContent = `${message} (Alerta #${this.alertCount})`;

    // Define o z-index de forma que o novo alerta fique atrás dos anteriores
    this.zIndex--;
    popup.style.zIndex = this.zIndex + '';

    // Adiciona o popup no body
    document.body.appendChild(popup);

    // Remove o popup após 2 segundos com um efeito de fade-out
    setTimeout(() => {
      popup.style.animation = 'fadeOut 0.5s forwards';
      setTimeout(() => {
        popup.remove(); // Remove o popup do DOM após a animação
      }, 500); // Tempo da animação fade-out
    }, 2000); // Popup aparece por 2 segundos
  }

}
