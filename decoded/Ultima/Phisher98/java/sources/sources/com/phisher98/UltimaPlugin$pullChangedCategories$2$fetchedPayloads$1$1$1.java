package com.phisher98;

import com.lagradost.api.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: UltimaPlugin.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Ultima/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lkotlin/Triple;", "Lcom/phisher98/SyncCategory;", "Lcom/phisher98/SyncCategoryMeta;", "Lcom/phisher98/SyncCategoryPayload;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.UltimaPlugin$pullChangedCategories$2$fetchedPayloads$1$1$1", f = "UltimaPlugin.kt", i = {}, l = {158}, m = "invokeSuspend", n = {}, nl = {159}, s = {}, v = 2)
final class UltimaPlugin$pullChangedCategories$2$fetchedPayloads$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Triple<? extends SyncCategory, ? extends SyncCategoryMeta, ? extends SyncCategoryPayload>>, Object> {
    final /* synthetic */ SyncCategory $category;
    final /* synthetic */ SyncCategoryMeta $meta;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UltimaPlugin$pullChangedCategories$2$fetchedPayloads$1$1$1(SyncCategory syncCategory, SyncCategoryMeta syncCategoryMeta, Continuation<? super UltimaPlugin$pullChangedCategories$2$fetchedPayloads$1$1$1> continuation) {
        super(2, continuation);
        this.$category = syncCategory;
        this.$meta = syncCategoryMeta;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UltimaPlugin$pullChangedCategories$2$fetchedPayloads$1$1$1(this.$category, this.$meta, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Triple<? extends SyncCategory, SyncCategoryMeta, SyncCategoryPayload>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object objFetchCategory;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
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
            if (payload == null || StringsKt.isBlank(payload.getData())) {
                return null;
            }
            return new Triple(this.$category, this.$meta, payload);
        } catch (Exception e) {
            Log.INSTANCE.e("UltimaSync", "Error fetching category " + this.$category.getKey() + ": " + e.getMessage());
            return null;
        }
    }
}
