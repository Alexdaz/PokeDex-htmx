import { html, LitElement } from './lit-all.min.js';

export class pkmBtn extends LitElement {
    static properties = {
        texto: { type: String }
    };

    render() {
        return html`
        <link href="css/tailwind.min.css" rel="stylesheet">
        <button class="bg-indigo-700 text-white font-bold w-full py-2 px-4 rounded-lg mt-4 hover:bg-indigo-600">
            ${this.texto}
        </button>
        `;
    }
}

export class pkmTitu extends LitElement {
    static properties = {
        texto: { type: String }
    };
    render() {
        return html`
        <link href="css/tailwind.min.css" rel="stylesheet">
        <h1 class="text-4xl font-bold my-5">${this.texto}</h1>
        `;
    }
}

customElements.define('pkm-btn', pkmBtn);
customElements.define('pkm-titu', pkmTitu);