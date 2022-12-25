import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Login from '../views/Login.vue'
import DashHome from '@/components/DashHome.vue'
import DashNewSurvey from '@/components/DashNewSurvey.vue'

import DashChart from '@/components/DashChart.vue'
import DashReport from '@/components/DashReport.vue'
import DashAccount from '@/components/DashAccount.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/login',
      name: 'login',
      component: Login
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    },
    {
      path: '/dash',
      // name: 'dashboard',
      component : () => import('../views/Dashboard.vue'),
      meta : {
        title : 'Dashboard'
      },
      children: [

        {
            path : '',
            name : 'dashboard',
            component: DashHome,
            meta : {
              title : 'Dashboard'
            }
        },

          {
            path : 'report',
            name : 'report',
            component: DashReport,
            meta : {
              title : 'Reports'
            }
    
        },

          {
            path : 'new',
            name : 'new',
            component: DashNewSurvey,
            meta : {
              title : 'Create New Survey'
            }
    
        },
          {
            path : 'chart',
            name : 'chart',
            component: DashChart,
            meta : {
              title : 'Chart Report'
            }
    
        },

          {
            path : 'account',
            name : 'admin_account',
            component: DashAccount,
            meta : {
              title : 'Account'
            }
    
        },

      ]
    
  
    },

    {
      path: '/client_dash',
      // name: 'dashboard',
      component : () => import('../views/Dashboard.vue'),
      meta : {
        title : 'Dashboard'
      },
      children: [

        {
            path : '',
            name : 'dashboard',
            component: DashHome,
            meta : {
              title : 'Dashboard'
            }
        },

          {
            path : 'report',
            name : 'report',
            component: DashReport,
            meta : {
              title : 'Reports'
            }
    
        },

          {
            path : 'account',
            name : 'admin_account',
            component: DashAccount,
            meta : {
              title : 'Account'
            }
    
        },

      ]
    
  
    },
    

  ]
})

export default router
