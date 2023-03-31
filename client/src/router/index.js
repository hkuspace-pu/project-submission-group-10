import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Login from '../views/Login.vue'
import Register from '../views/Register.vue'
import DashHome from '@/components/DashHome.vue'
import DashNewSurvey from '@/components/DashNewSurvey.vue'
import Blog from '@/components/Blog.vue'
import DashChart from '@/components/DashChart.vue'
import DashSurvey from '@/components/DashSurvey.vue'
import DashAccount from '@/components/DashAccount.vue'
import DashSyncFile from '@/components/DashSyncFile.vue'
import DashFeature from '@/components/DashFeature.vue'
import DashUsers from '@/components/DashUsers.vue'
import DashTreeLists from '@/components/DashTreeLists.vue'
import Page404 from '../views/Page404.vue'
// import DashNewFeature from '@/components/DashNewFeature.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  scrollBehavior(to,from, savedPosition) {
    return savedPosition || {top:0,behavior: 'smooth'}
    // return {top:,left;behaviour: }
  },
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
      path: '/register',
      name: 'register',
      component: Register
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
      path: '/privacy',
      name: 'privacy',
      component: () => import('../views/Privacy.vue')
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
            path : 'survey',
            name : 'survey',
            component: DashSurvey,
            meta : {
              title : 'Surveys'
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

          {
            path : 'syncfile',
            name : 'syncfile',
            component: DashSyncFile,
            meta : {
              title : 'TSV file handling'
            }
    
        },

          {
            path : 'feature',
            name : 'feature',
            component: DashFeature,
            meta : {
              title : 'News / Events / Features'
            }
    
        },

          {
            path : 'feature_new',
            name : 'feature_new',
            component: DashNewSurvey,
            meta : {
              title : 'Add News / Events / Features'
            }
    
        },

          {
            path : 'users',
            name : 'users',
            component: DashUsers,
            meta : {
              title : 'Users'
            }
    
        },
        {
          path : 'blog',
          name : 'blog',
          component: Blog,
          meta : {
            title : 'Blog'
          }
  
      },

          {
            path : 'trees',
            name : 'trees',
            component: DashTreeLists,
            meta : {
              title : 'Tree lists'
            }
    
        },

      ]
    
  
    },
    {
      path: '/404',
      name: '404',
      component: Page404
    },
    {
        path: '/:pathMatch(.*)',
        redirect: '/404'
    }

  ]
})

export default router
