import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import { VitePWA } from 'vite-plugin-pwa'
import mkcert from'vite-plugin-mkcert'
import browserSyncPlugin from 'vite-plugin-browser-sync';

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue(),
    mkcert(),
    browserSyncPlugin()
    // VitePWA({ 
    //   registerType: 'autoUpdate',
    //   devOptions: {enabled: true},
    //   includeAssets: ['favicon.ico', 'apple-touch-icon.png', 'masked-icon.svg'],

    // })
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
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
