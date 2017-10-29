# Kerfisstjórnun handbók

Til að setja upp verkefnið þarf að setja upp eftirfarandi:
* Postgres
* Heroku
* Travis

Svo þarf að sækja verkefnið frá GitHub frá þessari [slóð](https://github.com/HUB-Make-Software-Greate-Again/TicTacToe)
 en einnig er hægt er að gera git clone á þessa [slóð](https://github.com/HUB-Make-Software-Greate-Again/TicTacToe.git) í gegnum command line interface (CLI).
 
Eftir að verkefnið hefur verið sótt þarf að setja upp gagnagrunn í Postgres, það er gert í gegnum CLI með þessari skipun:
export DATABASE_URL=postgres://user:password@host:port/database_name 

Næst er eftirfarandi skipun keyrð í CLI til að keyra upp kerfið:
gradle run eða ./gradlew run

## Heroku uppsetning
Í CLI er þessi skipun keyrð til þess að búa til nýtt app í Heroku:
heroko apps:create 'nafnaverkefni-staging', það app er notað fyrir prufukeyrslur og prófanir.
Næsta skref er að fara inn á heroku heimasíðuna, nýskrá sig og bæta nýja verkefninu inn í nýtt "pipeline" og velja að setja það inn sem staging.

## Travis uppsetning
Fyrsta skrefið er að fara inn á heimasíðu Travis og skrá sig inn með GitHub aðgangi.
Næsta skref er að tengja nafnið á verkefninu við Travis aðganginn með því að setja nafnið á verkefninu (nafnaverkefni-staging) inn í .travis.yml skránna undir app i deploy.
Einnig þarf að bæta við secret key en það er gert með því að keyra þessa skipun í CLI:
```bash
travis encrypt $(heroku auth:token) --add deploy.api_key
```

Nú er búið til annað app á Heroku sem endar á nafninu -production (nafnaverkefni-production) í staðinn fyrir -staging (nafnaverkefni-staging) og er því bætt við sem production í "pipeline".
Það app er notað fyrir lokaútgáfu sem er gefin út.
Í staðinn fyrir að setja nafnið á nýja appinu í .travis.yml skránna, þá er farið inn í appið á heroku, farið í "deploy" flipann og valið github í deployment method.
Fyrir neðan í automatic deploys þarf að haka í "wait for CI to pass before deploy" og ýta svo á "enable Automatic deploys".

Tilgangurinn með því að búa til þessi tvö öpp er að fyrirbyggja að brotinn kóði endi inn á lokaútgáfu appsins.

Í hvert skiptið sem breytingar eiga sér stað er það prófað ítarlega á staging appinu og ef allar prófannir standast er því "deploy"-að á production appið.

