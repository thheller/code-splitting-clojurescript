# Code Splitting ClojureScript

This is a slightly modified [Code Splitting ClojureScript](https://code.thheller.com/blog/shadow-cljs/2019/03/03/code-splitting-clojurescript.html) example meant to demonstrate a "common" code-splitting scenario where a couple modules exist and each may depend on others.

## Building

You can compile it by cloning the repo and running

```
npm install
clj -M:dev:start
;; or
clj -M:dev:release
npx shadow-cljs release app
```

and then open http://localhost:8005.

The demo is hosted here:
- https://code.thheller.com/demos/code-splitting-esm/

### Optional: Build Reports

```
;; generate a build report via
npx shadow-cljs run shadow.cljs.build-report app report.html

;; then open report.html in the browser
```

The sample build report is available here:
- https://code.thheller.com/demos/code-splitting-esm/report.html