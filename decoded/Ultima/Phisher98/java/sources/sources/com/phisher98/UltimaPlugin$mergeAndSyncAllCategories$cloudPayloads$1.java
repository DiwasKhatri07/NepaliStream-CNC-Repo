package com.phisher98;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: UltimaPlugin.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Ultima/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lcom/phisher98/SyncCategory;", "Lcom/phisher98/SyncCategoryPayload;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.UltimaPlugin$mergeAndSyncAllCategories$cloudPayloads$1", f = "UltimaPlugin.kt", i = {0}, l = {732}, m = "invokeSuspend", n = {"$this$coroutineScope"}, nl = {-1}, s = {"L$0"}, v = 2)
@SourceDebugExtension({"SMAP\nUltimaPlugin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UltimaPlugin.kt\ncom/phisher98/UltimaPlugin$mergeAndSyncAllCategories$cloudPayloads$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,866:1\n1739#2:867\n1814#2,3:868\n*S KotlinDebug\n*F\n+ 1 UltimaPlugin.kt\ncom/phisher98/UltimaPlugin$mergeAndSyncAllCategories$cloudPayloads$1\n*L\n715#1:867\n715#1:868,3\n*E\n"})
final class UltimaPlugin$mergeAndSyncAllCategories$cloudPayloads$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<SyncCategory, ? extends SyncCategoryPayload>>, Object> {
    final /* synthetic */ List<SyncCategory> $enabledCategories;
    final /* synthetic */ SyncManifest $manifest;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    UltimaPlugin$mergeAndSyncAllCategories$cloudPayloads$1(List<? extends SyncCategory> list, SyncManifest syncManifest, Continuation<? super UltimaPlugin$mergeAndSyncAllCategories$cloudPayloads$1> continuation) {
        super(2, continuation);
        this.$enabledCategories = list;
        this.$manifest = syncManifest;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> ultimaPlugin$mergeAndSyncAllCategories$cloudPayloads$1 = new UltimaPlugin$mergeAndSyncAllCategories$cloudPayloads$1(this.$enabledCategories, this.$manifest, continuation);
        ultimaPlugin$mergeAndSyncAllCategories$cloudPayloads$1.L$0 = obj;
        return ultimaPlugin$mergeAndSyncAllCategories$cloudPayloads$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Map<SyncCategory, SyncCategoryPayload>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object objAwaitAll;
        CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Iterable $this$map$iv = this.$enabledCategories;
                SyncManifest syncManifest = this.$manifest;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    SyncCategory category = (SyncCategory) item$iv$iv;
                    destination$iv$iv.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new UltimaPlugin$mergeAndSyncAllCategories$cloudPayloads$1$1$1(syncManifest, category, null), 2, (Object) null));
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                this.label = 1;
                objAwaitAll = AwaitKt.awaitAll((List) destination$iv$iv, (Continuation) this);
                if (objAwaitAll == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                objAwaitAll = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return MapsKt.toMap((Iterable) objAwaitAll);
    }
}
