# ict-m324 - Programmieraufgabe 1

## Wichtig: Weitere Aufgaben gemäss Teams-Aufgabenstellung

Die Zusatzaufgaben wurden in separaten Verzeichnissen gelöst.


### Adaption

«_Adaptieren Sie Prozess aus Aufgabe 3 auf eine beliebige andere Programmiersprache.
Erstellen Sie eine kleine Applikation, die automatisch gelintet, formatiert und getestet wird._»  

→ wurde unter [adaption](adaption) gelöst.

### Python

«_Folgen Sie dieser Anleitung: https://infmod.gitlab.io/m324/automation/swtest/ 
Führen Sie am Ende python3 -m coverage xml -i aus und kopieren Sie die Ausgabe in das Textfeld._»  

→ wurde unter [swtest](swtest) gelöst.

## Node.js-Setup, Package Management, Linting, Formatting, Testing

1. [Voraussetzungen](#voraussetzungen)
2. [Projekt Setup und Paketmanagement](#projekt-setup-und-paketmanagement)
   - [Projektinitialisierung](#projektinitialisierung)
   - [Startskript erstellen](#startskript-erstellen)
   - [JS-Programmierung mit Paketen](#js-programmierung-mit-paketen)
   - [Paketmanagement und Updates](#paketmanagement-und-updates)
3. [Codequalität: Linting und Formatting](#codequalität-linting-und-formatting)
   - [ESLint installieren und konfigurieren](#eslint-installieren-und-konfigurieren)
   - [Prettier für Codeformatierung](#prettier-für-codeformatierung)
4. [Testing mit Mocha](#testing-mit-mocha)
   - [Mocha installieren und Tests erstellen](#mocha-installieren-und-tests-erstellen)
   - [Zusätzliche Tests hinzufügen](#zusätzliche-tests-hinzufügen)

---

### Voraussetzungen

- Überprüfen Sie in einem Terminal mit `node -v` und `npm -v`, ob NPM korrekt installiert ist. Falls nicht, installieren Sie Node.js und NPM (https://docs.npmjs.com/downloading-and-installing-node-js-and-npm).

---

### Projekt Setup und Paketmanagement

1. **Projektinitialisierung**:

   - Erstellen Sie ein neues Verzeichnis und initialisieren Sie das Projekt und wählen Sie überall den Default Wert und keine Erweiterungen:
     ```bash
     mkdir my-project
     cd my-project
     npm init -y
     ```
   - Achten Sie darauf, dass `"type": "module"` gesetzt ist. https://nodejs.org/docs/latest-v13.x/api/esm.html#esm_enabling
   - Erstellen Sie eine `index.js` Datei:

     ```javascript
     // index.js
     console.log('Hello, World!')
     ```

   - Erstellen Sie eine `.gitignore` Datei und fügen Sie `node_modules` hinzu.

2. **Startskript erstellen**:

   - Bearbeiten Sie `package.json`:
     ```json
     "scripts": {
       "start": "node index.js"
     }
     ```
   - Führen Sie das Skript aus:
     ```bash
     npm run start
     ```

3. **JS-Programmierung mit Paketen**:

   - Installieren Sie die NPM Pakete `random-words` und `chalk`:
   - Verwenden Sie `random-words` und `chalk`, um zufällige Wörter in der Konsole auszugeben.

     ```javascript
     // Fügen Sie hier die korrekten Imports ein. Verwenden Sie import, nicht require.

     const word1 = generate({ exactly: 1, minLength: 10, wordsPerString: 1 })
     const word2 = generate()
     console.log(
       `The ${chalk.greenBright(word1)} is ${chalk.redBright(word2)}.`,
     )
     ```

- Führen Sie das Programm aus, um die Ausgabe zu sehen:
  ```bash
  npm run start
  ```

4. **Paketmanagement und Updates**:

   - Installieren Sie eine ältere Version von `chalk`. Ändern Sie die Version in package.json und führen Sie `npm install` aus.
   - Installieren Sie `npm-check-updates` und aktualisieren Sie Ihre Pakete:
     ```bash
     npm install npm-check-updates
     ncu
     ncu -u
     npm install
     ```

   **_Konflikte lösen_**

   - Führen Sie `npm install eslint@3.12.1` aus.
   - Anschliessend `npm install babel-eslint@10.1.0`
   - Es tritt ein Problem auf. Achten Sie auf die Fehlerausgabe.
   - Welche Version von welchem Paket ist die Mindestanforderung?
   - Lösen Sie das Problem.
   - Aktualisieren Sie am Schluss eslint wieder auf die neueste Version und entfernen Sie babel-eslint.

---

### Codequalität: Linting und Formatting

1. **ESLint installieren und konfigurieren**:

   - Installieren und initialisieren Sie ESLint. https://eslint.org/

   - Verwenden Sie diese Konfiguration:

   ```js
   // eslint.config.js
   import globals from 'globals'
   import pluginJs from '@eslint/js'

   export default [
     { languageOptions: { globals: globals.browser } },
     pluginJs.configs.recommended,
   ]
   ```

   - Fügen Sie das Linting-Skript hinzu:
     `json
        "scripts": {
            "lint": "eslint ."
        }
`

   - Führen Sie das Linting aus:

   ```bash
   npm run lint
   ```

   - Fixen Sie die Linter Fehlermeldungen: `'describe' is not defined  no-undef`
     Erweitern Sie die ESLint Config mit `globals.mocha`.

   - Testen Sie den Linter, indem Sie folgende Fehlerfälle im Code einbauen. Achten Sie auf die Fehlermeldungen von ESLint:
     - Nicht verwendete Variable
     - Nicht definierte Variable
     - Verwendung von == anstelle von ===
     - Verwendung von var statt let oder const

2. **Prettier für Codeformatierung**:

   - Installieren Sie Prettier und erstellen Sie `.prettierrc`:
     ```bash
     npm install prettier
     ```
     ```json
     {
       "singleQuote": true,
       "semi": false
     }
     ```
   - Fügen Sie das Formatting-Skript hinzu und formatieren Sie den Code:

     ```json
     "scripts": {
       "format-write": "prettier --write ."
     }
     ```

     ```bash
     npm run format
     ```

   - Schreiben Sie ein weiteres Formatting-Skript und "format-check". Dieses Skript soll die Dateien nicht verändern und nur Formatierungsfehler ausgeben.
   - Testen Sie den Formatter, indem Sie z.B. Leerzeichen an den Anfang einer Datei anfügen.

- ```

  ```

---

### Testing mit Mocha

1. **Mocha installieren und Tests erstellen**:

   - Installieren Sie Mocha:
     ```bash
     npm install mocha
     ```
   - Fügen Sie die diesen Code zu `index.js` hinzu:

   ```javascript
   export const sum = (a, b) => {
     return a + b
   }
   ```

   - Erstellen Sie `index.test.js`:

     ```javascript
     import { strict as assert } from 'assert'
     import { sum } from './index.js'

     describe('sum', () => {
       it('should return 3 for 1 + 2', () => {
         // Korrigieren Sie den Test
         assert.equal(sum(1, 2), 4)
       })
     })
     ```

   - Fügen Sie das Test-Skript hinzu:
     ```json
     "scripts": {
       "test": "mocha"
     }
     ```
   -

```json
"scripts": {
  "test": "node node_modules/.bin/mocha ./"
}
```

- Hinweis: Wenn es bei Windows nicht klappt, versuchen Sie: `node --experimental-vm-modules node_modules/.bin/mocha ./`

- Führen Sie die Tests aus:
  ```bash
  npm run test
  ```

2. **Zusätzliche Tests hinzufügen**:
   - Verbessern Sie die Code Coverage durch weitere Tests, z.B. ob Dezimalzahlen korrekt berechnet werden.
