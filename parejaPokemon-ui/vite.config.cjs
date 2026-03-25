const { defineConfig } = require("vite");

module.exports = defineConfig({
  build: {
    outDir: "../demo/src/main/resources/static",
    emptyOutDir: true,
  },
});
