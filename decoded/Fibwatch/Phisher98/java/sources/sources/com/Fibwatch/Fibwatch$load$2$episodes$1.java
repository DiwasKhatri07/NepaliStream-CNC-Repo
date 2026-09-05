package com.Fibwatch;

import com.lagradost.cloudstream3.Episode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.sync.Semaphore;

/* JADX INFO: compiled from: Fibwatch.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Fibwatch/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/Episode;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.Fibwatch.Fibwatch$load$2$episodes$1", f = "Fibwatch.kt", i = {0}, l = {273}, m = "invokeSuspend", n = {"$this$coroutineScope"}, nl = {-1}, s = {"L$0"}, v = 2)
@SourceDebugExtension({"SMAP\nFibwatch.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Fibwatch.kt\ncom/Fibwatch/Fibwatch$load$2$episodes$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,363:1\n1739#2:364\n1814#2,3:365\n*S KotlinDebug\n*F\n+ 1 Fibwatch.kt\ncom/Fibwatch/Fibwatch$load$2$episodes$1\n*L\n194#1:364\n194#1:365,3\n*E\n"})
final class Fibwatch$load$2$episodes$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Episode>>, Object> {
    final /* synthetic */ Function1<List<LoadItem>, List<LoadItem>> $dedupeByUrl;
    final /* synthetic */ List<EpisodeItem> $episodesList;
    final /* synthetic */ String $poster;
    final /* synthetic */ Semaphore $semaphore;
    final /* synthetic */ Function3<String, String, Boolean, LoadItem> $toLoadItem;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ Fibwatch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    Fibwatch$load$2$episodes$1(List<EpisodeItem> list, Semaphore semaphore, Function1<? super List<LoadItem>, ? extends List<LoadItem>> function1, Function3<? super String, ? super String, ? super Boolean, LoadItem> function3, Fibwatch fibwatch, String str, Continuation<? super Fibwatch$load$2$episodes$1> continuation) {
        super(2, continuation);
        this.$episodesList = list;
        this.$semaphore = semaphore;
        this.$dedupeByUrl = function1;
        this.$toLoadItem = function3;
        this.this$0 = fibwatch;
        this.$poster = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> fibwatch$load$2$episodes$1 = new Fibwatch$load$2$episodes$1(this.$episodesList, this.$semaphore, this.$dedupeByUrl, this.$toLoadItem, this.this$0, this.$poster, continuation);
        fibwatch$load$2$episodes$1.L$0 = obj;
        return fibwatch$load$2$episodes$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<Episode>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object objAwaitAll;
        CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Iterable $this$map$iv = this.$episodesList;
                Semaphore semaphore = this.$semaphore;
                Function1<List<LoadItem>, List<LoadItem>> function1 = this.$dedupeByUrl;
                Function3<String, String, Boolean, LoadItem> function3 = this.$toLoadItem;
                Fibwatch fibwatch = this.this$0;
                String str = this.$poster;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    EpisodeItem ep = (EpisodeItem) item$iv$iv;
                    Collection destination$iv$iv2 = destination$iv$iv;
                    destination$iv$iv2.add(BuildersKt.async$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new Fibwatch$load$2$episodes$1$1$1(semaphore, ep, function1, function3, fibwatch, str, null), 3, (Object) null));
                    destination$iv$iv = destination$iv$iv2;
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
        return CollectionsKt.filterNotNull((Iterable) objAwaitAll);
    }
}
