from smart_contract_app.models import *
from smart_contract_app.serializers import *
from rest_framework import mixins
from rest_framework import generics

class AppUserList(mixins.ListModelMixin, 
                  mixins.CreateModelMixin,
                  generics.GenericAPIView):
     queryset = AppUser.objects.all()
     serializer_class = AppUserSerializer

     def get(self, request, *args, **kwargs):
         return self.list(request, *args, **kwargs)

     def post(self, request, *args, **kwargs):
         return self.create(request, *args, **kwargs)

class AppUserDetail(mixins.RetrieveModelMixin,
                    mixins.UpdateModelMixin,
                    mixins.DestroyModelMixin,
                    generics.GenericAPIView):
    queryset = AppUser.objects.all()
    serializer_class = AppUserSerializer

    def get(self, request, *args, **kwargs):
        return self.retrieve(request, *args, **kwargs)

    def put(self, request, *args, **kwargs):
        return self.update(request, *args, **kwargs)

    def delete(self, request, *args, **kwargs):
        return self.destroy(request, *args, **kwargs)

class CropList(mixins.ListModelMixin, 
               mixins.CreateModelMixin,
               generics.GenericAPIView):
    queryset = Crop.objects.all()
    serializer_class = CropSerializer

    def get(self, request, *args, **kwargs):
        return self.list(request, *args, **kwargs)
    
    def post(self, request, *args, **kwargs):
        return self.create(request, *args, **kwargs)

class SharePurchaseList(mixins.ListModelMixin,
                        mixins.CreateModelMixin,
                        generics.GenericAPIView):
    quertset = SharePurchase.objects.all()
    serializer_class = SharePurchaseSerializer

    def get(self, request, *args, **kwargs):
        return self.list(request, *args, **kwargs)

    def post(self, request, *args, **kwargs):
        return self.create(request, *args, **kwargs)
