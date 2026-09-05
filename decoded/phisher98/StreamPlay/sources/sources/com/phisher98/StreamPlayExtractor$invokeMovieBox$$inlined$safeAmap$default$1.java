package com.phisher98;

import com.fasterxml.jackson.databind.ObjectMapper;
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
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeMovieBox$$inlined$safeAmap$default$1", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class StreamPlayExtractor$invokeMovieBox$$inlined$safeAmap$default$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Unit>>, Object> {
    final /* synthetic */ Function1 $callback$inlined;
    final /* synthetic */ int $concurrency;
    final /* synthetic */ Integer $episode$inlined;
    final /* synthetic */ Ref.BooleanRef $foundLinks$inlined;
    final /* synthetic */ Map $headers$inlined;
    final /* synthetic */ ObjectMapper $mapper$inlined;
    final /* synthetic */ Integer $season$inlined;
    final /* synthetic */ Function1 $subtitleCallback$inlined;
    final /* synthetic */ Iterable $this_runCatching;
    final /* synthetic */ String $token$inlined;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamPlayExtractor$invokeMovieBox$$inlined$safeAmap$default$1(int i, Iterable iterable, Continuation continuation, Map map, String str, ObjectMapper objectMapper, Integer num, Integer num2, Function1 function1, Ref.BooleanRef booleanRef, Function1 function2) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$headers$inlined = map;
        this.$token$inlined = str;
        this.$mapper$inlined = objectMapper;
        this.$season$inlined = num;
        this.$episode$inlined = num2;
        this.$callback$inlined = function1;
        this.$foundLinks$inlined = booleanRef;
        this.$subtitleCallback$inlined = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> streamPlayExtractor$invokeMovieBox$$inlined$safeAmap$default$1 = new StreamPlayExtractor$invokeMovieBox$$inlined$safeAmap$default$1(this.$concurrency, this.$this_runCatching, continuation, this.$headers$inlined, this.$token$inlined, this.$mapper$inlined, this.$season$inlined, this.$episode$inlined, this.$callback$inlined, this.$foundLinks$inlined, this.$subtitleCallback$inlined);
        streamPlayExtractor$invokeMovieBox$$inlined$safeAmap$default$1.L$0 = obj;
        return streamPlayExtractor$invokeMovieBox$$inlined$safeAmap$default$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Unit>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeMovieBox$$inlined$safeAmap$default$1$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeMovieBox$$inlined$safeAmap$default$1$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6}, l = {2266, 2283, 2340, 2362, 2406, 2466, 2479}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "id", "subjectUrl", "subjectXToken", "subjectXSign", "subjectHeaders", "$this$withPermit$iv", "$completion", "id", "subjectUrl", "subjectXToken", "subjectXSign", "subjectRes", "subjectHeaders", "xUserHeader", "authtoken", "subjectJson", "subjectIds", "originalLanguageName", "dubs", "subjectData", "language", "subjectId", "playUrl", "token", "sign", "playHeaders", "$this$withPermit$iv", "$completion", "id", "subjectUrl", "subjectXToken", "subjectXSign", "subjectRes", "subjectHeaders", "xUserHeader", "authtoken", "subjectJson", "subjectIds", "originalLanguageName", "dubs", "subjectData", "language", "subjectId", "playUrl", "token", "sign", "playRes", "playHeaders", "playRoot", "stream", "streams", "format", "signCookie", "streamId", "resolutionNodes", "resNode", "resUrl", "quality", "$this$withPermit$iv", "$completion", "id", "subjectUrl", "subjectXToken", "subjectXSign", "subjectRes", "subjectHeaders", "xUserHeader", "authtoken", "subjectJson", "subjectIds", "originalLanguageName", "dubs", "subjectData", "language", "subjectId", "playUrl", "token", "sign", "playRes", "playHeaders", "playRoot", "stream", "streams", "format", "signCookie", "streamId", "resolutionNodes", "singleUrl", "resText", "$this$withPermit$iv", "$completion", "id", "subjectUrl", "subjectXToken", "subjectXSign", "subjectRes", "subjectHeaders", "xUserHeader", "authtoken", "subjectJson", "subjectIds", "originalLanguageName", "dubs", "subjectData", "language", "subjectId", "playUrl", "token", "sign", "playRes", "playHeaders", "playRoot", "stream", "streams", "format", "signCookie", "streamId", "resolutionNodes", "subLinks", "subLink", "subToken", "subSign", "subHeaders", "$this$withPermit$iv", "$completion", "id", "subjectUrl", "subjectXToken", "subjectXSign", "subjectRes", "subjectHeaders", "xUserHeader", "authtoken", "subjectJson", "subjectIds", "originalLanguageName", "dubs", "subjectData", "language", "subjectId", "playUrl", "token", "sign", "playRes", "playHeaders", "playRoot", "stream", "streams", "format", "signCookie", "streamId", "resolutionNodes", "subLinks", "subLink", "subToken", "subSign", "subHeaders", "subRes", "subRoot", "captions", "caption", "lang", "captionUrl"}, nl = {2267, 2285, 2341, 2361, 2405, 2467, 2478}, s = {"L$0", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$33", "L$34", "I$0", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$32", "L$33", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$32", "L$34", "L$35", "L$36", "L$37", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$32", "L$34", "L$35", "L$36", "L$37", "L$39", "L$40", "L$42", "L$43", "L$44", "L$45"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2493\n3852#3,24:2269\n3876#3,199:2294\n1#4:2293\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n*L\n1889#1:2266,3\n1889#1:2493,2\n*E\n"})
    public static final class C01791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1 $callback$inlined;
        final /* synthetic */ Integer $episode$inlined;
        final /* synthetic */ Ref.BooleanRef $foundLinks$inlined;
        final /* synthetic */ Map $headers$inlined;
        final /* synthetic */ Object $item;
        final /* synthetic */ ObjectMapper $mapper$inlined;
        final /* synthetic */ Integer $season$inlined;
        final /* synthetic */ Semaphore $semaphore;
        final /* synthetic */ Function1 $subtitleCallback$inlined;
        final /* synthetic */ String $token$inlined;
        int I$0;
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
        Object L$21;
        Object L$22;
        Object L$23;
        Object L$24;
        Object L$25;
        Object L$26;
        Object L$27;
        Object L$28;
        Object L$29;
        Object L$3;
        Object L$30;
        Object L$31;
        Object L$32;
        Object L$33;
        Object L$34;
        Object L$35;
        Object L$36;
        Object L$37;
        Object L$38;
        Object L$39;
        Object L$4;
        Object L$40;
        Object L$41;
        Object L$42;
        Object L$43;
        Object L$44;
        Object L$45;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01791(Semaphore semaphore, Object obj, Continuation continuation, Map map, String str, ObjectMapper objectMapper, Integer num, Integer num2, Function1 function1, Ref.BooleanRef booleanRef, Function1 function2) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$headers$inlined = map;
            this.$token$inlined = str;
            this.$mapper$inlined = objectMapper;
            this.$season$inlined = num;
            this.$episode$inlined = num2;
            this.$callback$inlined = function1;
            this.$foundLinks$inlined = booleanRef;
            this.$subtitleCallback$inlined = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C01791(this.$semaphore, this.$item, continuation, this.$headers$inlined, this.$token$inlined, this.$mapper$inlined, this.$season$inlined, this.$episode$inlined, this.$callback$inlined, this.$foundLinks$inlined, this.$subtitleCallback$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:211:0x0c2f  */
        /* JADX WARN: Code duplicated, block: B:335:0x119d A[Catch: all -> 0x176c, Exception -> 0x1778, TRY_LEAVE, TryCatch #3 {Exception -> 0x1778, blocks: (B:333:0x1197, B:335:0x119d), top: B:511:0x1197 }] */
        /* JADX WARN: Code duplicated, block: B:341:0x133a A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:342:0x133b  */
        /* JADX WARN: Code duplicated, block: B:345:0x1364 A[Catch: all -> 0x16d4, Exception -> 0x16dd, TryCatch #66 {Exception -> 0x16dd, all -> 0x16d4, blocks: (B:343:0x1356, B:345:0x1364, B:347:0x1378, B:350:0x1386, B:352:0x138c), top: B:574:0x1356 }] */
        /* JADX WARN: Code duplicated, block: B:347:0x1378 A[Catch: all -> 0x16d4, Exception -> 0x16dd, TryCatch #66 {Exception -> 0x16dd, all -> 0x16d4, blocks: (B:343:0x1356, B:345:0x1364, B:347:0x1378, B:350:0x1386, B:352:0x138c), top: B:574:0x1356 }] */
        /* JADX WARN: Code duplicated, block: B:348:0x1381  */
        /* JADX WARN: Code duplicated, block: B:350:0x1386 A[Catch: all -> 0x16d4, Exception -> 0x16dd, TryCatch #66 {Exception -> 0x16dd, all -> 0x16d4, blocks: (B:343:0x1356, B:345:0x1364, B:347:0x1378, B:350:0x1386, B:352:0x138c), top: B:574:0x1356 }] */
        /* JADX WARN: Code duplicated, block: B:356:0x13d9 A[Catch: all -> 0x167c, Exception -> 0x1688, TryCatch #59 {Exception -> 0x1688, all -> 0x167c, blocks: (B:354:0x13d3, B:356:0x13d9, B:358:0x13ef, B:361:0x1405, B:385:0x1463, B:371:0x1438), top: B:588:0x13d3 }] */
        /* JADX WARN: Code duplicated, block: B:389:0x159a A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:390:0x159b  */
        /* JADX WARN: Code duplicated, block: B:407:0x16a8  */
        /* JADX WARN: Code duplicated, block: B:599:0x1623 A[SYNTHETIC] */
        /* JADX WARN: Path cross not found for [B:523:0x07d9, B:63:0x07f2], limit reached: 601 */
        /* JADX WARN: Path cross not found for [B:547:0x0899, B:135:0x093c], limit reached: 601 */
        /* JADX WARN: Path cross not found for [B:578:0x0bb2, B:194:0x0bd2], limit reached: 601 */
        /* JADX WARN: Path cross not found for [B:596:0x1411, B:370:0x1436], limit reached: 601 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:181:0x0b72 -> B:534:0x0b96). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:267:0x0e42 -> B:580:0x0c59). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:332:0x116d -> B:511:0x1197). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:353:0x1390 -> B:588:0x13d3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:390:0x159b -> B:521:0x15b5). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:449:0x18cc -> B:508:0x0957). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        public final java.lang.Object invokeSuspend(java.lang.Object r78) {
            /*
                Method dump skipped, instruction units count: 6748
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.phisher98.StreamPlayExtractor$invokeMovieBox$$inlined$safeAmap$default$1.C01791.invokeSuspend(java.lang.Object):java.lang.Object");
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
                    destination$iv$iv2.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new C01791(semaphore, item$iv$iv, null, this.$headers$inlined, this.$token$inlined, this.$mapper$inlined, this.$season$inlined, this.$episode$inlined, this.$callback$inlined, this.$foundLinks$inlined, this.$subtitleCallback$inlined), 2, (Object) null));
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
