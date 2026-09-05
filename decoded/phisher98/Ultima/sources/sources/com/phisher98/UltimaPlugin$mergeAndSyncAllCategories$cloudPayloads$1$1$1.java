package com.phisher98;

import com.lagradost.api.Log;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: UltimaPlugin.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Ultima/classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/phisher98/SyncCategory;", "Lcom/phisher98/SyncCategoryPayload;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.UltimaPlugin$mergeAndSyncAllCategories$cloudPayloads$1$1$1", f = "UltimaPlugin.kt", i = {0, 0}, l = {724}, m = "invokeSuspend", n = {"cloudMeta", "localHash"}, nl = {725}, s = {"L$0", "L$1"}, v = 2)
final class UltimaPlugin$mergeAndSyncAllCategories$cloudPayloads$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends SyncCategory, ? extends SyncCategoryPayload>>, Object> {
    final /* synthetic */ SyncCategory $category;
    final /* synthetic */ SyncManifest $manifest;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UltimaPlugin$mergeAndSyncAllCategories$cloudPayloads$1$1$1(SyncManifest syncManifest, SyncCategory syncCategory, Continuation<? super UltimaPlugin$mergeAndSyncAllCategories$cloudPayloads$1$1$1> continuation) {
        super(2, continuation);
        this.$manifest = syncManifest;
        this.$category = syncCategory;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UltimaPlugin$mergeAndSyncAllCategories$cloudPayloads$1$1$1(this.$manifest, this.$category, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends SyncCategory, SyncCategoryPayload>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object objFetchCategory;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    SyncManifest syncManifest = this.$manifest;
                    SyncCategoryMeta cloudMeta = syncManifest != null ? syncManifest.getMeta(this.$category) : null;
                    String localHash = UltimaStorageManager.INSTANCE.getCategoryHash(this.$category);
                    if (cloudMeta != null) {
                        if ((cloudMeta.getHash().length() > 0) && Intrinsics.areEqual(cloudMeta.getHash(), localHash)) {
                            Log.INSTANCE.d("UltimaSync", "Skipping cloud download for " + this.$category.getKey() + ": hash matches local");
                            return TuplesKt.to(this.$category, (Object) null);
                        }
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(cloudMeta);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(localHash);
                    this.label = 1;
                    objFetchCategory = UltimaSettingsSyncUtils.INSTANCE.fetchCategory(this.$category, (Continuation) this);
                    if (objFetchCategory == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    objFetchCategory = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            SyncCategoryPayload payload = (SyncCategoryPayload) objFetchCategory;
            return TuplesKt.to(this.$category, payload);
        } catch (Exception e) {
            Log.INSTANCE.e("UltimaSync", "Error fetching category " + this.$category.getKey() + ": " + e.getMessage());
            return TuplesKt.to(this.$category, (Object) null);
        }
    }
}
