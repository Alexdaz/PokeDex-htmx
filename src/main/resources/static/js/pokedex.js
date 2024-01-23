var url = null;

window.addEventListener("htmx:configRequest", function (event) {
    let pathWithParameters = event.detail.path.replace(/:([A-Za-z0-9_]+)/g, function (_match) {
        let poke = document.getElementById("pok").value;

        document.getElementById('Titulo').innerHTML = poke.replace('-',' ');
        return poke.toLowerCase();
    });

    url = event.detail.path;

    event.detail.path = pathWithParameters;
});

window.addEventListener('htmx:afterSettle', function (event) {
    if (event.detail.target.id === 'pokemon') {
        var responseText = event.detail.xhr.responseText;
        var jsonResponse = JSON.parse(responseText);

        document.getElementById('Nopokedex').innerHTML = 'No. ' + jsonResponse.id;
        document.getElementById('Expbase').innerHTML = 'EXP Base: ' + (jsonResponse?.base_experience ?? 0);
        document.getElementById('Altura').innerHTML = jsonResponse.height / 10 + 'm';
        document.getElementById('Peso').innerHTML = jsonResponse.weight / 10 + 'kg.';

        document.getElementById('tipo1').innerHTML = jsonResponse.types[0].type.name;
        document.getElementById('tipo2').innerHTML = jsonResponse?.types[1]?.type.name ?? '-';

        document.getElementById("pkmn").src = jsonResponse.sprites.other["official-artwork"].front_default;

        document.getElementById("type1").src = 'img/' + jsonResponse.types[0].type.name + '.png';

        if (jsonResponse?.types[1]?.type.name != null) {
            document.getElementById("type2").style.display = "block";
            document.getElementById("type2").src = 'img/' + jsonResponse.types[1].type.name + '.png';
        }
        else {
            document.getElementById("type2").style.display = "none";
        }

        document.getElementById("btnSave").style.display = "block";
    }
});

window.addEventListener('htmx:afterRequest', function (evt) {
    const targetError = evt.target.attributes.getNamedItem('hx-target-error')
    if (evt.detail.failed && targetError) {
      document.getElementById('error').style.display = "inline";
    }
});

window.addEventListener('htmx:beforeRequest', function (evt) {
  const targetError = evt.target.attributes.getNamedItem('hx-target-error')
  if (targetError) {
    document.getElementById('error').style.display = "none";
  }
});

htmx.defineExtension('submitjson', {
    onEvent: function (name, evt) {
        if (name === "htmx:configRequest") {
            evt.detail.path = url;
            evt.detail.headers['Content-Type'] = "application/json";
            evt.detail.headers['PDEX-API-KEY'] = 'Hai1234'
        }
    },
    encodeParameters: function (xhr) {
        xhr.overrideMimeType('text/json')

        var jsonPoke = {
            nombre: upperFirstChar(document.getElementById("pok").value),
            tipo1: upperFirstChar(document.getElementById('tipo1').innerHTML),
            tipo2: document.getElementById('tipo2').innerHTML == '-' ? null : upperFirstChar(document.getElementById('tipo2').innerHTML),
            nopokedex: parseInt(document.getElementById("Nopokedex").innerHTML.replace('No. ','')),
            expbase: parseInt(document.getElementById("Expbase").innerHTML.replace('EXP Base: ','')),
            altura: parseFloat(document.getElementById("Altura").innerHTML.replace('m','')),
            peso: parseInt(document.getElementById("Peso").innerHTML.replace('kg.',''))
        };

        return (JSON.stringify(jsonPoke));
    }
})

function upperFirstChar(word) {
    return word.charAt(0).toUpperCase() + word.slice(1).toLowerCase();
}