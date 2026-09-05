package com.phisher98;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;

/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokehdhub4u$$inlined$safeAmap$default$1", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class StreamPlayExtractor$invokehdhub4u$$inlined$safeAmap$default$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Unit>>, Object> {
    final /* synthetic */ Function1 $callback$inlined;
    final /* synthetic */ int $concurrency;
    final /* synthetic */ Integer $episode$inlined;
    final /* synthetic */ Integer $season$inlined;
    final /* synthetic */ Function1 $subtitleCallback$inlined;
    final /* synthetic */ Iterable $this_runCatching;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamPlayExtractor$invokehdhub4u$$inlined$safeAmap$default$1(int i, Iterable iterable, Continuation continuation, Integer num, Function1 function1, Function1 function2, Integer num2) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$season$inlined = num;
        this.$subtitleCallback$inlined = function1;
        this.$callback$inlined = function2;
        this.$episode$inlined = num2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> streamPlayExtractor$invokehdhub4u$$inlined$safeAmap$default$1 = new StreamPlayExtractor$invokehdhub4u$$inlined$safeAmap$default$1(this.$concurrency, this.$this_runCatching, continuation, this.$season$inlined, this.$subtitleCallback$inlined, this.$callback$inlined, this.$episode$inlined);
        streamPlayExtractor$invokehdhub4u$$inlined$safeAmap$default$1.L$0 = obj;
        return streamPlayExtractor$invokehdhub4u$$inlined$safeAmap$default$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Unit>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokehdhub4u$$inlined$safeAmap$default$1$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokehdhub4u$$inlined$safeAmap$default$1$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, l = {2266, 2269, 2277, 2280, 2302, 2304, 2326, 2328, 2341, 2342}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "el", "$this$withPermit$iv", "$completion", "el", "doc", "qualityLinks", "linkEl", "resolvedLink", "$this$invokehdhub4u_u24lambda_u243_u240", "$this$withPermit$iv", "$completion", "el", "doc", "qualityLinks", "linkEl", "resolvedLink", "resolvedWatch", "$this$withPermit$iv", "$completion", "el", "doc", "episodeRegex", "h3s", "h3", "episodeLink", "watchLink", "episodeNum", "links", "href", "$this$withPermit$iv", "$completion", "el", "doc", "episodeRegex", "h3s", "h3", "episodeLink", "watchLink", "episodeNum", "links", "href", "resolved", "$this$invokehdhub4u_u24lambda_u243_u243_u240", "$this$withPermit$iv", "$completion", "el", "doc", "episodeRegex", "h3s", "h3", "episodeLink", "watchLink", "episodeNum", "links", "href", "resolved", "element$iv", "$this$forEach$iv", "episodeDoc", "resolvedLink", "$this$invokehdhub4u_u24lambda_u243_u243_u242_u240", "$this$withPermit$iv", "$completion", "el", "doc", "episodeRegex", "h3s", "h3", "episodeLink", "watchLink", "episodeNum", "links", "href", "resolved", "element$iv", "$this$forEach$iv", "episodeDoc", "resolvedLink", "resolvedWatch", "$this$withPermit$iv", "$completion", "el", "doc", "episodeRegex", "h3s", "h3", "episodeLink", "watchLink", "episodeNum", "links", "watchHref", "$this$withPermit$iv", "$completion", "el", "doc", "episodeRegex", "h3s", "h3", "episodeLink", "watchLink", "episodeNum", "links", "watchHref", "resolvedWatch"}, nl = {2267, 2271, 2277, 2289, 2304, 2304, 2326, 2335, 2340, 2349}, s = {"L$0", "L$0", "L$2", "L$3", "L$0", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$0", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$16", "L$17", "L$18", "L$19", "L$20", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$16", "L$17", "L$18", "L$19", "L$20", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2354\n3558#3,9:2269\n3567#3,30:2279\n3597#3:2323\n3598#3,11:2325\n3609#3,17:2337\n1#4:2278\n1#4:2320\n1795#5,10:2309\n2068#5:2319\n2069#5:2321\n1805#5:2322\n2068#5:2324\n2069#5:2336\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n*L\n1889#1:2266,3\n1889#1:2354,2\n3596#2:2320\n3596#2:2309,10\n3596#2:2319\n3596#2:2321\n3596#2:2322\n3597#2:2324\n3597#2:2336\n*E\n"})
    public static final class C02431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1 $callback$inlined;
        final /* synthetic */ Integer $episode$inlined;
        final /* synthetic */ Object $item;
        final /* synthetic */ Integer $season$inlined;
        final /* synthetic */ Semaphore $semaphore;
        final /* synthetic */ Function1 $subtitleCallback$inlined;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
        Object L$18;
        Object L$19;
        Object L$2;
        Object L$20;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02431(Semaphore semaphore, Object obj, Continuation continuation, Integer num, Function1 function1, Function1 function2, Integer num2) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$season$inlined = num;
            this.$subtitleCallback$inlined = function1;
            this.$callback$inlined = function2;
            this.$episode$inlined = num2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C02431(this.$semaphore, this.$item, continuation, this.$season$inlined, this.$subtitleCallback$inlined, this.$callback$inlined, this.$episode$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:112:0x0618 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:113:0x0619  */
        /* JADX WARN: Code duplicated, block: B:69:0x04d3 A[Catch: all -> 0x0686, Exception -> 0x0691, TRY_LEAVE, TryCatch #64 {Exception -> 0x0691, all -> 0x0686, blocks: (B:67:0x04cd, B:69:0x04d3), top: B:536:0x04cd }] */
        /* JADX WARN: Code duplicated, block: B:75:0x04fc A[Catch: all -> 0x064a, Exception -> 0x0653, TRY_LEAVE, TryCatch #68 {Exception -> 0x0653, all -> 0x064a, blocks: (B:73:0x04f6, B:75:0x04fc), top: B:528:0x04f6 }] */
        /* JADX WARN: Code duplicated, block: B:80:0x0539 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:81:0x053a  */
        /* JADX WARN: Code duplicated, block: B:84:0x054d  */
        /* JADX WARN: Code duplicated, block: B:97:0x0594  */
        /* JADX WARN: Not initialized variable reg: 1, insn: 0x0374: MOVE (r14 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY] A[D('$this$withPermit$iv' kotlinx.coroutines.sync.Semaphore)]), block:B:33:0x0372 */
        /* JADX WARN: Not initialized variable reg: 25, insn: 0x0375: MOVE (r1 I:??[OBJECT, ARRAY] A[D('$this$withPermit$iv' kotlinx.coroutines.sync.Semaphore)]) = (r25 I:??[OBJECT, ARRAY]), block:B:33:0x0372 */
        /* JADX WARN: Unreachable blocks removed: 2, instructions: 8 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:113:0x0619 -> B:114:0x0623). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:373:0x0e27 -> B:534:0x0e32). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        public final java.lang.Object invokeSuspend(java.lang.Object r48) {
            /*
                Method dump skipped, instruction units count: 4010
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.phisher98.StreamPlayExtractor$invokehdhub4u$$inlined$safeAmap$default$1.C02431.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object objAwaitAll;
        CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Semaphore semaphore = SemaphoreKt.Semaphore$default(this.$concurrency, 0, 2, (Object) null);
                Iterable $this$map$iv = this.$this_runCatching;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    Collection destination$iv$iv2 = destination$iv$iv;
                    destination$iv$iv2.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new C02431(semaphore, item$iv$iv, null, this.$season$inlined, this.$subtitleCallback$inlined, this.$callback$inlined, this.$episode$inlined), 2, (Object) null));
                    destination$iv$iv = destination$iv$iv2;
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(semaphore);
                this.label = 1;
                objAwaitAll = AwaitKt.awaitAll((List) destination$iv$iv, (Continuation) this);
                if (objAwaitAll == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
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
