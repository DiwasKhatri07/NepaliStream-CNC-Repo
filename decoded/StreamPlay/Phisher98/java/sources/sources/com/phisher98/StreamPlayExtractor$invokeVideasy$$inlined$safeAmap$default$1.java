package com.phisher98;

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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;

/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeVideasy$$inlined$safeAmap$default$1", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class StreamPlayExtractor$invokeVideasy$$inlined$safeAmap$default$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Unit>>, Object> {
    final /* synthetic */ Function1 $callback$inlined;
    final /* synthetic */ int $concurrency;
    final /* synthetic */ int $enc$inlined;
    final /* synthetic */ String $encTitle$inlined;
    final /* synthetic */ Integer $episode$inlined;
    final /* synthetic */ Map $headers$inlined;
    final /* synthetic */ String $imdbId$inlined;
    final /* synthetic */ Integer $season$inlined;
    final /* synthetic */ String $seed$inlined;
    final /* synthetic */ Function1 $subtitleCallback$inlined;
    final /* synthetic */ Iterable $this_runCatching;
    final /* synthetic */ Integer $tmdbId$inlined;
    final /* synthetic */ Ref.ObjectRef $workingApi$inlined;
    final /* synthetic */ Integer $year$inlined;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamPlayExtractor$invokeVideasy$$inlined$safeAmap$default$1(int i, Iterable iterable, Continuation continuation, Integer num, Ref.ObjectRef objectRef, String str, Integer num2, Integer num3, String str2, int i2, String str3, Integer num4, Map map, Function1 function1, Function1 function2) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$season$inlined = num;
        this.$workingApi$inlined = objectRef;
        this.$encTitle$inlined = str;
        this.$year$inlined = num2;
        this.$tmdbId$inlined = num3;
        this.$imdbId$inlined = str2;
        this.$enc$inlined = i2;
        this.$seed$inlined = str3;
        this.$episode$inlined = num4;
        this.$headers$inlined = map;
        this.$callback$inlined = function1;
        this.$subtitleCallback$inlined = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> streamPlayExtractor$invokeVideasy$$inlined$safeAmap$default$1 = new StreamPlayExtractor$invokeVideasy$$inlined$safeAmap$default$1(this.$concurrency, this.$this_runCatching, continuation, this.$season$inlined, this.$workingApi$inlined, this.$encTitle$inlined, this.$year$inlined, this.$tmdbId$inlined, this.$imdbId$inlined, this.$enc$inlined, this.$seed$inlined, this.$episode$inlined, this.$headers$inlined, this.$callback$inlined, this.$subtitleCallback$inlined);
        streamPlayExtractor$invokeVideasy$$inlined$safeAmap$default$1.L$0 = obj;
        return streamPlayExtractor$invokeVideasy$$inlined$safeAmap$default$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Unit>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeVideasy$$inlined$safeAmap$default$1$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeVideasy$$inlined$safeAmap$default$1$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {2266, 2275, 2278, 2322, 2343}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "server", "url", "$this$withPermit$iv", "$completion", "server", "url", "enc_data", "jsonBody", "$this$withPermit$iv", "$completion", "server", "url", "enc_data", "response", "jsonBody", "$this$forEach$iv", "element$iv", "sourceObj", "sourceUrl", "qualityStr", "type", "parsed", "$this$withPermit$iv", "$completion", "server", "url", "enc_data", "response", "jsonBody", "$this$forEach$iv", "element$iv", "subObj", "subUrl", "parsedLang", "langStr", "finalLang", "parsed"}, nl = {2267, 2277, 2283, 2321, 2342}, s = {"L$0", "L$0", "L$2", "L$3", "L$4", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "L$12", "L$13", "L$14", "L$16", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$17"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 7 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2351\n1948#3,16:2269\n1965#3:2308\n1966#3,23:2310\n1990#3:2334\n1991#3,13:2336\n2005#3:2350\n93#4,2:2285\n63#4:2287\n64#4,15:2289\n95#4,2:2306\n1#5:2288\n50#6:2304\n43#6:2305\n2068#7:2309\n2069#7:2333\n2068#7:2335\n2069#7:2349\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n*L\n1889#1:2266,3\n1889#1:2351,2\n1963#2:2285,2\n1963#2:2287\n1963#2:2289,15\n1963#2:2306,2\n1963#2:2288\n1963#2:2304\n1963#2:2305\n1965#2:2309\n1965#2:2333\n1990#2:2335\n1990#2:2349\n*E\n"})
    public static final class C02231 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1 $callback$inlined;
        final /* synthetic */ int $enc$inlined;
        final /* synthetic */ String $encTitle$inlined;
        final /* synthetic */ Integer $episode$inlined;
        final /* synthetic */ Map $headers$inlined;
        final /* synthetic */ String $imdbId$inlined;
        final /* synthetic */ Object $item;
        final /* synthetic */ Integer $season$inlined;
        final /* synthetic */ String $seed$inlined;
        final /* synthetic */ Semaphore $semaphore;
        final /* synthetic */ Function1 $subtitleCallback$inlined;
        final /* synthetic */ Integer $tmdbId$inlined;
        final /* synthetic */ Ref.ObjectRef $workingApi$inlined;
        final /* synthetic */ Integer $year$inlined;
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
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02231(Semaphore semaphore, Object obj, Continuation continuation, Integer num, Ref.ObjectRef objectRef, String str, Integer num2, Integer num3, String str2, int i, String str3, Integer num4, Map map, Function1 function1, Function1 function2) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$season$inlined = num;
            this.$workingApi$inlined = objectRef;
            this.$encTitle$inlined = str;
            this.$year$inlined = num2;
            this.$tmdbId$inlined = num3;
            this.$imdbId$inlined = str2;
            this.$enc$inlined = i;
            this.$seed$inlined = str3;
            this.$episode$inlined = num4;
            this.$headers$inlined = map;
            this.$callback$inlined = function1;
            this.$subtitleCallback$inlined = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C02231(this.$semaphore, this.$item, continuation, this.$season$inlined, this.$workingApi$inlined, this.$encTitle$inlined, this.$year$inlined, this.$tmdbId$inlined, this.$imdbId$inlined, this.$enc$inlined, this.$seed$inlined, this.$episode$inlined, this.$headers$inlined, this.$callback$inlined, this.$subtitleCallback$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:131:0x050e A[Catch: all -> 0x06cc, Exception -> 0x06d4, TryCatch #20 {all -> 0x06cc, blocks: (B:129:0x0508, B:131:0x050e, B:134:0x0524, B:137:0x052f), top: B:306:0x0508 }] */
        /* JADX WARN: Code duplicated, block: B:133:0x0522  */
        /* JADX WARN: Code duplicated, block: B:136:0x052a  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:136:0x052a -> B:168:0x0649). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:165:0x061e -> B:354:0x063b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:214:0x0755 -> B:229:0x081c). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:226:0x07e7 -> B:360:0x0803). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        public final java.lang.Object invokeSuspend(java.lang.Object r35) {
            /*
                Method dump skipped, instruction units count: 2468
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.phisher98.StreamPlayExtractor$invokeVideasy$$inlined$safeAmap$default$1.C02231.invokeSuspend(java.lang.Object):java.lang.Object");
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
                    CoroutineScope $this$coroutineScope2 = $this$coroutineScope;
                    Collection destination$iv$iv2 = destination$iv$iv;
                    $this$coroutineScope = $this$coroutineScope2;
                    destination$iv$iv2.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new C02231(semaphore, item$iv$iv, null, this.$season$inlined, this.$workingApi$inlined, this.$encTitle$inlined, this.$year$inlined, this.$tmdbId$inlined, this.$imdbId$inlined, this.$enc$inlined, this.$seed$inlined, this.$episode$inlined, this.$headers$inlined, this.$callback$inlined, this.$subtitleCallback$inlined), 2, (Object) null));
                    $this$map$iv = $this$map$iv;
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
