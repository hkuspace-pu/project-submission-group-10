import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import { VitePWA } from 'vite-plugin-pwa'
import mkcert from'vite-plugin-mkcert'



// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue(),
    mkcert(),
    VitePWA({ 
      registerType: 'autoUpdate',
      devOptions: {enabled: true},
      includeAssets: ['favicon.ico', 'apple-touch-icon.png', 'masked-icon.svg'],

    })],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  },
  server: {
    https:true
  }
})
