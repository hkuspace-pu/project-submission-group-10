import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Login from '../views/Login.vue'
import DashHome from '@/components/DashHome.vue'
import DashNewSurvey from '@/components/DashNewSurvey.vue'

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
          path : 'new',
          name : 'new',
          component: DashNewSurvey,
          meta : {
            title : 'Create New Survey'
          }
  
      },

   
    ]
    
  
  
  
  
     },


    

  ]
})

export default router
