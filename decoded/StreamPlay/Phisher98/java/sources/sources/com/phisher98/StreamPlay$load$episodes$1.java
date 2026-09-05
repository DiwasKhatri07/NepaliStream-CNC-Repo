package com.phisher98;

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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;

/* JADX INFO: compiled from: StreamPlay.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/Episode;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlay$load$episodes$1", f = "StreamPlay.kt", i = {0, 0}, l = {516}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {461}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlay.kt\ncom/phisher98/StreamPlay$load$episodes$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,929:1\n1739#2:930\n1814#2,3:931\n*S KotlinDebug\n*F\n+ 1 StreamPlay.kt\ncom/phisher98/StreamPlay$load$episodes$1\n*L\n461#1:930\n461#1:931,3\n*E\n"})
final class StreamPlay$load$episodes$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Episode>>, Object> {
    final /* synthetic */ StreamPlay.Data $data;
    final /* synthetic */ String $enTitle;
    final /* synthetic */ boolean $isAnime;
    final /* synthetic */ boolean $isAsian;
    final /* synthetic */ boolean $isBollywood;
    final /* synthetic */ boolean $isCartoon;
    final /* synthetic */ Integer $lastSeason;
    final /* synthetic */ String $orgTitle;
    final /* synthetic */ Ref.ObjectRef<StreamPlay.MediaDetail> $res;
    final /* synthetic */ String $tmdbAPI;
    final /* synthetic */ Integer $year;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ StreamPlay this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreamPlay$load$episodes$1(Ref.ObjectRef<StreamPlay.MediaDetail> objectRef, String str, StreamPlay.Data data, StreamPlay streamPlay, String str2, String str3, boolean z, Integer num, Integer num2, boolean z2, boolean z3, boolean z4, Continuation<? super StreamPlay$load$episodes$1> continuation) {
        super(2, continuation);
        this.$res = objectRef;
        this.$tmdbAPI = str;
        this.$data = data;
        this.this$0 = streamPlay;
        this.$enTitle = str2;
        this.$orgTitle = str3;
        this.$isAnime = z;
        this.$year = num;
        this.$lastSeason = num2;
        this.$isAsian = z2;
        this.$isBollywood = z3;
        this.$isCartoon = z4;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> streamPlay$load$episodes$1 = new StreamPlay$load$episodes$1(this.$res, this.$tmdbAPI, this.$data, this.this$0, this.$enTitle, this.$orgTitle, this.$isAnime, this.$year, this.$lastSeason, this.$isAsian, this.$isBollywood, this.$isCartoon, continuation);
        streamPlay$load$episodes$1.L$0 = obj;
        return streamPlay$load$episodes$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<Episode>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Semaphore semaphore;
        Object objAwaitAll;
        Semaphore semaphore2;
        List list;
        List listFilterNotNull;
        List listFlatten;
        CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                semaphore = SemaphoreKt.Semaphore$default(10, 0, 2, (Object) null);
                Iterable seasons = ((StreamPlay.MediaDetail) this.$res.element).getSeasons();
                if (seasons != null) {
                    Iterable $this$map$iv = seasons;
                    String str = this.$tmdbAPI;
                    StreamPlay.Data data = this.$data;
                    StreamPlay streamPlay = this.this$0;
                    Ref.ObjectRef<StreamPlay.MediaDetail> objectRef = this.$res;
                    String str2 = this.$enTitle;
                    String str3 = this.$orgTitle;
                    boolean z = this.$isAnime;
                    Integer num = this.$year;
                    Integer num2 = this.$lastSeason;
                    boolean z2 = this.$isAsian;
                    boolean z3 = this.$isBollywood;
                    CoroutineScope $this$coroutineScope2 = $this$coroutineScope;
                    boolean z4 = this.$isCartoon;
                    boolean z5 = z;
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        boolean z6 = z2;
                        StreamPlay.Seasons season = (StreamPlay.Seasons) item$iv$iv;
                        Integer num3 = num2;
                        boolean z7 = z3;
                        boolean z8 = z5;
                        Integer num4 = num;
                        StreamPlay$load$episodes$1$1$1 streamPlay$load$episodes$1$1$1 = new StreamPlay$load$episodes$1$1$1(semaphore, str, data, season, streamPlay, objectRef, str2, str3, z8, num4, num3, z6, z7, z4, null);
                        Semaphore semaphore3 = semaphore;
                        Collection destination$iv$iv2 = destination$iv$iv;
                        CoroutineScope $this$coroutineScope3 = $this$coroutineScope2;
                        destination$iv$iv2.add(BuildersKt.async$default($this$coroutineScope3, (CoroutineContext) null, (CoroutineStart) null, streamPlay$load$episodes$1$1$1, 3, (Object) null));
                        $this$coroutineScope2 = $this$coroutineScope3;
                        destination$iv$iv = destination$iv$iv2;
                        semaphore = semaphore3;
                        num = num4;
                        num2 = num3;
                        z2 = z6;
                        z3 = z7;
                        $this$map$iv = $this$map$iv;
                        z5 = z8;
                    }
                    Semaphore semaphore4 = semaphore;
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope2);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(semaphore4);
                    this.label = 1;
                    objAwaitAll = AwaitKt.awaitAll((List) destination$iv$iv, (Continuation) this);
                    if (objAwaitAll == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    semaphore2 = semaphore4;
                    list = (List) objAwaitAll;
                    if (list == null && (listFilterNotNull = CollectionsKt.filterNotNull(list)) != null && (listFlatten = CollectionsKt.flatten(listFilterNotNull)) != null) {
                        return listFlatten;
                    }
                    semaphore = semaphore2;
                }
                return CollectionsKt.emptyList();
            case 1:
                semaphore2 = (Semaphore) this.L$1;
                ResultKt.throwOnFailure($result);
                objAwaitAll = $result;
                list = (List) objAwaitAll;
                if (list == null) {
                    break;
                }
                semaphore = semaphore2;
                return CollectionsKt.emptyList();
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
