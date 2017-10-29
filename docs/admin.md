# Kerfisstjórnunar handbók
Leiðbeiningar fyrir kerfisstjóra til þess að setja upp verkefnið á nýrri vél, keyra það og viðhalda því.

## Forkröfur
Eftirfarandi þurfa að vera til staðar á tölvu sem ætlar að keyra verkefnið:
1. Postgres
2. Heroku
3. Travis

## Uppsetning
Sækja þarf verkefnið frá GitHub frá þessari [slóð](https://github.com/HUB-Make-Software-Greate-Again/TicTacToe)
 en einnig er hægt er að gera þessa skipun í CLI (command line interface)
 ```bash
git clone https://github.com/HUB-Make-Software-Greate-Again/TicTacToe.git
```

Eftir að verkefnið hefur verið sótt þarf að setja upp gagnagrunn í Postgres, það er gert í gegnum CLI með þessari skipun:
```bash
export DATABASE_URL=postgres://user:password@host:port/databasename 
```
Næst er eftirfarandi skipun keyrð í CLI til að keyra upp kerfið:
`gradle run` eða `./gradlew run`.

## Heroku uppsetning
Í CLI er þessi skipun keyrð til þess að búa til nýtt app í Heroku:
```bash
heroko apps:create 'productname-staging'
```
Það app er notað fyrir prufukeyrslur og prófanir.
Næsta skref er að fara inn á [Heroku](https://www.heroku.com/) heimasíðuna, innskrá eða nýskrá sig og bæta nýja verkefninu inn í nýtt _pipeline_ og velja að setja það inn sem _staging_.

## Travis uppsetning
Fyrsta skrefið er að fara inn á heimasíðu [Travis](https://travis-ci.org/) og skrá sig inn með GitHub aðgangi.
Næsta skref er að tengja nafnið á verkefninu við Travis aðganginn með því að setja nafnið á verkefninu (productname-staging) inn í .travis.yml skránna í _app_ undir _deploy_.
Einnig þarf að bæta við _secret key_ en það er gert með því að keyra þessa skipun í CLI:
```bash
travis encrypt $(heroku auth:token) --add deploy.api_key
```

Nú er búið til annað app á Heroku sem endar á nafninu -production (productname-production) í staðinn fyrir -staging (productname-staging) og er því bætt við sem "production" í _pipeline_.
Það app er notað fyrir lokaútgáfu sem er gefin út.
Í staðinn fyrir að setja nafnið á nýja appinu í .travis.yml skránna, þá er farið inn í appið á Heroku, farið í _deploy_ flipann og valið GitHub í _deployment method_.
Fyrir neðan í _automatic deploys_ þarf að haka í _wait for CI to pass before deploy_ og ýta svo á _enable Automatic deploys_.

Tilgangurinn með því að búa til þessi tvö öpp er að fyrirbyggja að brotinn kóði endi inn á lokaútgáfu appsins.

Í hvert skiptið sem breytingar eiga sér stað er það prófað ítarlega á _staging_ appinu og ef allar prófannir standast er því "deploy-að" á _production_ appið.

