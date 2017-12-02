from django.contrib import admin

from .models import * 

admin.site.register(AppUser)
admin.site.register(Land)
admin.site.register(Crop)
admin.site.register(SharePurchase)
admin.site.register(CropPurchase)
