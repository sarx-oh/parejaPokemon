const { defineConfig } = require("vite");

module.exports = defineConfig({
  server: {
    proxy: {
      "/pokemons": {
        target: "http://localhost:8080",
        changeOrigin: true,
      },
    },
  },
  build: {
    outDir: "../demo/src/main/resources/static",
    emptyOutDir: true,
  },
});
