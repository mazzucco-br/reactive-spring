const proxy = [
  {
    context: '/api',
    target: 'http://localhost:9090/contratos',
    pathRewrite: {'^/api' : ''}
  }
];
