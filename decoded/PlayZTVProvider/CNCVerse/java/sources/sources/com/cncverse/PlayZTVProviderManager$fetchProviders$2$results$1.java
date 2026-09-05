package com.cncverse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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

/* JADX INFO: compiled from: PlayZTVProviderManager.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/PlayZTVProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u00010\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.cncverse.PlayZTVProviderManager$fetchProviders$2$results$1", f = "PlayZTVProviderManager.kt", i = {0}, l = {285}, m = "invokeSuspend", n = {"$this$coroutineScope"}, nl = {-1}, s = {"L$0"}, v = 2)
@SourceDebugExtension({"SMAP\nPlayZTVProviderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayZTVProviderManager.kt\ncom/cncverse/PlayZTVProviderManager$fetchProviders$2$results$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,427:1\n1586#2:428\n1661#2,3:429\n*S KotlinDebug\n*F\n+ 1 PlayZTVProviderManager.kt\ncom/cncverse/PlayZTVProviderManager$fetchProviders$2$results$1\n*L\n202#1:428\n202#1:429,3\n*E\n"})
final class PlayZTVProviderManager$fetchProviders$2$results$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends List<? extends Map<String, ? extends Object>>>>, Object> {
    final /* synthetic */ List<PlayZTVCategoryWrapper> $wrappers;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlayZTVProviderManager$fetchProviders$2$results$1(List<PlayZTVCategoryWrapper> list, Continuation<? super PlayZTVProviderManager$fetchProviders$2$results$1> continuation) {
        super(2, continuation);
        this.$wrappers = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> playZTVProviderManager$fetchProviders$2$results$1 = new PlayZTVProviderManager$fetchProviders$2$results$1(this.$wrappers, continuation);
        playZTVProviderManager$fetchProviders$2$results$1.L$0 = obj;
        return playZTVProviderManager$fetchProviders$2$results$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends List<? extends Map<String, ? extends Object>>>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Iterable $this$map$iv = this.$wrappers;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    PlayZTVCategoryWrapper wrapper = (PlayZTVCategoryWrapper) item$iv$iv;
                    destination$iv$iv.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new PlayZTVProviderManager$fetchProviders$2$results$1$1$1(wrapper, null), 2, (Object) null));
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                this.label = 1;
                Object objAwaitAll = AwaitKt.awaitAll((List) destination$iv$iv, (Continuation) this);
                if (objAwaitAll == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objAwaitAll;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
