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
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeGoated$$inlined$safeAmap$default$1", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class StreamPlayExtractor$invokeGoated$$inlined$safeAmap$default$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Unit>>, Object> {
    final /* synthetic */ byte[] $actualKey$inlined;
    final /* synthetic */ Function1 $callback$inlined;
    final /* synthetic */ int $concurrency;
    final /* synthetic */ Integer $episode$inlined;
    final /* synthetic */ boolean $isTv$inlined;
    final /* synthetic */ String $refererPath$inlined;
    final /* synthetic */ Integer $season$inlined;
    final /* synthetic */ String $sessionIp$inlined;
    final /* synthetic */ String $sessionJwt$inlined;
    final /* synthetic */ Iterable $this_runCatching;
    final /* synthetic */ Integer $tmdbId$inlined;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamPlayExtractor$invokeGoated$$inlined$safeAmap$default$1(int i, Iterable iterable, Continuation continuation, byte[] bArr, String str, String str2, String str3, Function1 function1, boolean z, Integer num, Integer num2, Integer num3) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$actualKey$inlined = bArr;
        this.$sessionJwt$inlined = str;
        this.$sessionIp$inlined = str2;
        this.$refererPath$inlined = str3;
        this.$callback$inlined = function1;
        this.$isTv$inlined = z;
        this.$tmdbId$inlined = num;
        this.$season$inlined = num2;
        this.$episode$inlined = num3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> streamPlayExtractor$invokeGoated$$inlined$safeAmap$default$1 = new StreamPlayExtractor$invokeGoated$$inlined$safeAmap$default$1(this.$concurrency, this.$this_runCatching, continuation, this.$actualKey$inlined, this.$sessionJwt$inlined, this.$sessionIp$inlined, this.$refererPath$inlined, this.$callback$inlined, this.$isTv$inlined, this.$tmdbId$inlined, this.$season$inlined, this.$episode$inlined);
        streamPlayExtractor$invokeGoated$$inlined$safeAmap$default$1.L$0 = obj;
        return streamPlayExtractor$invokeGoated$$inlined$safeAmap$default$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Unit>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeGoated$$inlined$safeAmap$default$1$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeGoated$$inlined$safeAmap$default$1$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {2266, 2298, 2386}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "provider", "dParam", "encodedDParam", "payloadJson", "$this$withPermit$iv", "$completion", "provider", "dParam", "encodedDParam", "streamRes", "payloadJson", "streamData", "streams", "stream", "encryptedUrl", "quality", "finalUrl", "rawServerName", "serverName", "hasAuto", "isM3u8"}, nl = {2267, 2310, 2385}, s = {"L$0", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "I$0", "I$1"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 6 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 7 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 8 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2395\n6165#3,24:2269\n6189#3,19:2294\n6208#3,10:2318\n6220#3,4:2351\n6225#3,33:2358\n6269#3,4:2391\n1#4:2293\n1#4:2331\n73#5,5:2313\n93#6,2:2328\n63#6:2330\n64#6,15:2332\n95#6,2:2349\n50#7:2347\n43#7:2348\n1960#8,3:2355\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n*L\n1889#1:2266,3\n1889#1:2395,2\n6217#2:2331\n6207#2:2313,5\n6217#2:2328,2\n6217#2:2330\n6217#2:2332,15\n6217#2:2349,2\n6217#2:2347\n6217#2:2348\n6223#2:2355,3\n*E\n"})
    public static final class C01561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ byte[] $actualKey$inlined;
        final /* synthetic */ Function1 $callback$inlined;
        final /* synthetic */ Integer $episode$inlined;
        final /* synthetic */ boolean $isTv$inlined;
        final /* synthetic */ Object $item;
        final /* synthetic */ String $refererPath$inlined;
        final /* synthetic */ Integer $season$inlined;
        final /* synthetic */ Semaphore $semaphore;
        final /* synthetic */ String $sessionIp$inlined;
        final /* synthetic */ String $sessionJwt$inlined;
        final /* synthetic */ Integer $tmdbId$inlined;
        int I$0;
        int I$1;
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
        public C01561(Semaphore semaphore, Object obj, Continuation continuation, byte[] bArr, String str, String str2, String str3, Function1 function1, boolean z, Integer num, Integer num2, Integer num3) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$actualKey$inlined = bArr;
            this.$sessionJwt$inlined = str;
            this.$sessionIp$inlined = str2;
            this.$refererPath$inlined = str3;
            this.$callback$inlined = function1;
            this.$isTv$inlined = z;
            this.$tmdbId$inlined = num;
            this.$season$inlined = num2;
            this.$episode$inlined = num3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C01561(this.$semaphore, this.$item, continuation, this.$actualKey$inlined, this.$sessionJwt$inlined, this.$sessionIp$inlined, this.$refererPath$inlined, this.$callback$inlined, this.$isTv$inlined, this.$tmdbId$inlined, this.$season$inlined, this.$episode$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:166:0x0550 A[Catch: all -> 0x081a, Exception -> 0x0823, TRY_LEAVE, TryCatch #34 {Exception -> 0x0823, all -> 0x081a, blocks: (B:164:0x054a, B:166:0x0550), top: B:375:0x054a }] */
        /* JADX WARN: Code duplicated, block: B:171:0x0566  */
        /* JADX WARN: Code duplicated, block: B:182:0x0594 A[Catch: all -> 0x059e, Exception -> 0x05a4, TRY_LEAVE, TryCatch #35 {Exception -> 0x05a4, all -> 0x059e, blocks: (B:180:0x0585, B:182:0x0594, B:205:0x05f8, B:210:0x0616, B:245:0x067b, B:251:0x06a1, B:258:0x06cc, B:218:0x062b, B:224:0x063a, B:226:0x0640, B:232:0x0651, B:234:0x0657), top: B:373:0x0585 }] */
        /* JADX WARN: Code duplicated, block: B:194:0x05c1 A[Catch: all -> 0x07ec, Exception -> 0x07f5, TRY_LEAVE, TryCatch #39 {Exception -> 0x07f5, all -> 0x07ec, blocks: (B:177:0x057b, B:192:0x05b8, B:194:0x05c1, B:198:0x05ca, B:203:0x05e8, B:207:0x060e, B:242:0x066b, B:249:0x068d, B:256:0x06b1, B:261:0x06d3, B:260:0x06cf, B:215:0x0623), top: B:365:0x057b }] */
        /* JADX WARN: Code duplicated, block: B:196:0x05c7  */
        /* JADX WARN: Code duplicated, block: B:200:0x05d9 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:205:0x05f8 A[Catch: all -> 0x059e, Exception -> 0x05a4, TRY_ENTER, TRY_LEAVE, TryCatch #35 {Exception -> 0x05a4, all -> 0x059e, blocks: (B:180:0x0585, B:182:0x0594, B:205:0x05f8, B:210:0x0616, B:245:0x067b, B:251:0x06a1, B:258:0x06cc, B:218:0x062b, B:224:0x063a, B:226:0x0640, B:232:0x0651, B:234:0x0657), top: B:373:0x0585 }] */
        /* JADX WARN: Code duplicated, block: B:209:0x0614  */
        /* JADX WARN: Code duplicated, block: B:213:0x0620  */
        /* JADX WARN: Code duplicated, block: B:215:0x0623 A[Catch: all -> 0x07ec, Exception -> 0x07f5, TRY_ENTER, TRY_LEAVE, TryCatch #39 {Exception -> 0x07f5, all -> 0x07ec, blocks: (B:177:0x057b, B:192:0x05b8, B:194:0x05c1, B:198:0x05ca, B:203:0x05e8, B:207:0x060e, B:242:0x066b, B:249:0x068d, B:256:0x06b1, B:261:0x06d3, B:260:0x06cf, B:215:0x0623), top: B:365:0x057b }] */
        /* JADX WARN: Code duplicated, block: B:217:0x0629  */
        /* JADX WARN: Code duplicated, block: B:222:0x0637 A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:224:0x063a A[Catch: all -> 0x059e, Exception -> 0x05a4, TryCatch #35 {Exception -> 0x05a4, all -> 0x059e, blocks: (B:180:0x0585, B:182:0x0594, B:205:0x05f8, B:210:0x0616, B:245:0x067b, B:251:0x06a1, B:258:0x06cc, B:218:0x062b, B:224:0x063a, B:226:0x0640, B:232:0x0651, B:234:0x0657), top: B:373:0x0585 }] */
        /* JADX WARN: Code duplicated, block: B:226:0x0640 A[Catch: all -> 0x059e, Exception -> 0x05a4, TryCatch #35 {Exception -> 0x05a4, all -> 0x059e, blocks: (B:180:0x0585, B:182:0x0594, B:205:0x05f8, B:210:0x0616, B:245:0x067b, B:251:0x06a1, B:258:0x06cc, B:218:0x062b, B:224:0x063a, B:226:0x0640, B:232:0x0651, B:234:0x0657), top: B:373:0x0585 }] */
        /* JADX WARN: Code duplicated, block: B:230:0x064e A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:232:0x0651 A[Catch: all -> 0x059e, Exception -> 0x05a4, TryCatch #35 {Exception -> 0x05a4, all -> 0x059e, blocks: (B:180:0x0585, B:182:0x0594, B:205:0x05f8, B:210:0x0616, B:245:0x067b, B:251:0x06a1, B:258:0x06cc, B:218:0x062b, B:224:0x063a, B:226:0x0640, B:232:0x0651, B:234:0x0657), top: B:373:0x0585 }] */
        /* JADX WARN: Code duplicated, block: B:234:0x0657 A[Catch: all -> 0x059e, Exception -> 0x05a4, TryCatch #35 {Exception -> 0x05a4, all -> 0x059e, blocks: (B:180:0x0585, B:182:0x0594, B:205:0x05f8, B:210:0x0616, B:245:0x067b, B:251:0x06a1, B:258:0x06cc, B:218:0x062b, B:224:0x063a, B:226:0x0640, B:232:0x0651, B:234:0x0657), top: B:373:0x0585 }] */
        /* JADX WARN: Code duplicated, block: B:238:0x0665 A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:240:0x0668  */
        /* JADX WARN: Code duplicated, block: B:244:0x067a  */
        /* JADX WARN: Code duplicated, block: B:247:0x068a  */
        /* JADX WARN: Code duplicated, block: B:251:0x06a1 A[Catch: all -> 0x059e, Exception -> 0x05a4, TRY_ENTER, TRY_LEAVE, TryCatch #35 {Exception -> 0x05a4, all -> 0x059e, blocks: (B:180:0x0585, B:182:0x0594, B:205:0x05f8, B:210:0x0616, B:245:0x067b, B:251:0x06a1, B:258:0x06cc, B:218:0x062b, B:224:0x063a, B:226:0x0640, B:232:0x0651, B:234:0x0657), top: B:373:0x0585 }] */
        /* JADX WARN: Code duplicated, block: B:255:0x06b0  */
        /* JADX WARN: Code duplicated, block: B:258:0x06cc A[Catch: all -> 0x059e, Exception -> 0x05a4, TRY_ENTER, TRY_LEAVE, TryCatch #35 {Exception -> 0x05a4, all -> 0x059e, blocks: (B:180:0x0585, B:182:0x0594, B:205:0x05f8, B:210:0x0616, B:245:0x067b, B:251:0x06a1, B:258:0x06cc, B:218:0x062b, B:224:0x063a, B:226:0x0640, B:232:0x0651, B:234:0x0657), top: B:373:0x0585 }] */
        /* JADX WARN: Code duplicated, block: B:260:0x06cf A[Catch: all -> 0x07ec, Exception -> 0x07f5, TRY_ENTER, TryCatch #39 {Exception -> 0x07f5, all -> 0x07ec, blocks: (B:177:0x057b, B:192:0x05b8, B:194:0x05c1, B:198:0x05ca, B:203:0x05e8, B:207:0x060e, B:242:0x066b, B:249:0x068d, B:256:0x06b1, B:261:0x06d3, B:260:0x06cf, B:215:0x0623), top: B:365:0x057b }] */
        /* JADX WARN: Code duplicated, block: B:265:0x0757 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:266:0x0758  */
        /* JADX WARN: Code duplicated, block: B:277:0x07cb  */
        /* JADX WARN: Code duplicated, block: B:359:0x0560 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:373:0x0585 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:379:0x05e8 A[ADDED_TO_REGION, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:381:0x0805 A[SYNTHETIC] */
        /* JADX WARN: Path cross not found for [B:359:0x0560, B:176:0x0579], limit reached: 364 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:266:0x0758 -> B:357:0x0782). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        public final java.lang.Object invokeSuspend(java.lang.Object r39) {
            /*
                Method dump skipped, instruction units count: 2312
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.phisher98.StreamPlayExtractor$invokeGoated$$inlined$safeAmap$default$1.C01561.invokeSuspend(java.lang.Object):java.lang.Object");
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
                    destination$iv$iv2.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new C01561(semaphore, item$iv$iv, null, this.$actualKey$inlined, this.$sessionJwt$inlined, this.$sessionIp$inlined, this.$refererPath$inlined, this.$callback$inlined, this.$isTv$inlined, this.$tmdbId$inlined, this.$season$inlined, this.$episode$inlined), 2, (Object) null));
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
