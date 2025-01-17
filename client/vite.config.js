import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

import mkcert from'vite-plugin-mkcert'


// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue(),
    mkcert(),


  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url)),
      // ml5: 'ml5/dist/ml5.min.js',
    }
  },
  server: {
    host: '0.0.0.0',
    port: '3001',
    https:true,
    disableHostCheck : true,
    // hmr: {clientPort:443},
    // public: '192.168.50.143:8080'
  }
})
