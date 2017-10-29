# Þróunarhandbók    
Leiðbeiningar til þess að setja upp verkefnið á nýrri vél.

## Forkröfur
Eftirfarandi þurfa að vera til staðar á tölvu sem ætlar að keyra verkefnið.

1. Setja upp Java Development Kit
2. Setja upp Postgres
3. Setja upp GIT

## Uppsetning
Það sem þarf að gera til að keyra verkefnið er:

1. Sækja verkefnið á [github.com](https://github.com/HUB-Make-Software-Greate-Again/TicTacToe).
2. Búa til notanda með lykilorð í postgres og búa til einhvern tóman gagnagrunn.
3. Stilla umhverfisbreytuna `DATABASE_URL` sem DNS tengistreng á gagagrunninn.
4. Keyra `./gradlew run`

Dæmi um stillingu á `DATABASE_URL`þar sem eftirfarandi er keyrt í skel:
```bash 
export DATABASE_URL=postgres://user:password@localhost:5432/tictactoe
```

## Prófanir
Til þess að keyra Selenium prófanir þarf að stilla eftirfarandi umhverfisbreytur:
1. `HEROKU_APP_NAME` Slóðin sem á að prófa gegn
2. `SAUCE_USERNAME` Notendanafn á [Saucelabs](https://saucelabs.com)
3. `SAUCE_ACCESS_KEY` Aðgangslykill á [Saucelabs](https://saucelabs.com)

Til að keyra gegn `localhost` þá þarf að taka nokkur auka skref, sjá [hér](https://wiki.saucelabs.com/display/DOCS/Sauce+Connect+Proxy)

Dæmi um stillingar á umhverfisbreytum í skel
```bash
export HEROKU_APP_NAME=host:port
export SAUCE_USERNAME=foobar
export SAUCE_ACCESS_KEY=ab3bara3-b864-b3d4-b751-po78f6foo133
```
