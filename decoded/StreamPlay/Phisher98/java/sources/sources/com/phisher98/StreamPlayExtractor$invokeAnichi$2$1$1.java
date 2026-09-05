package com.phisher98;

import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: StreamPlayExtractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeAnichi$2$1$1", f = "StreamPlayExtractor.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7}, l = {654, 670, 686, 701, 710, 722, 738, 753}, m = "invokeSuspend", n = {"sourceUrl", "host", "sourceUrl", "fixedLink", "host", "sourceUrl", "decoded", "fixedLink", "sourceUrl", "decoded", "fixedLink", "links", "$this$forEach$iv", "element$iv", "server", "host", "sourceUrl", "decoded", "fixedLink", "links", "$this$forEach$iv", "element$iv", "server", "host", "sourceUrl", "decoded", "fixedLink", "links", "$this$forEach$iv", "element$iv", "server", "host", "sourceUrl", "decoded", "fixedLink", "links", "$this$forEach$iv", "element$iv", "server", "host", "endpoint", "sourceUrl", "decoded", "fixedLink", "links", "$this$forEach$iv", "element$iv", "server", "host", "$this$forEach$iv", "element$iv", "sub", "src", "langName"}, nl = {662, 679, 687, 705, 720, 721, 742, 754}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$10", "L$11", "L$12", "L$13", "L$0", "L$1", "L$2", "L$3", "L$4", "L$10", "L$11", "L$12", "L$13", "L$15", "L$16", "L$17", "L$18"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor$invokeAnichi$2$1$1\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,6034:1\n73#2,5:6035\n2068#3:6040\n2068#3,2:6041\n2068#3,2:6043\n2068#3,2:6045\n2069#3:6047\n*S KotlinDebug\n*F\n+ 1 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor$invokeAnichi$2$1$1\n*L\n687#1:6035,5\n694#1:6040\n705#1:6041,2\n742#1:6043,2\n746#1:6045,2\n694#1:6047\n*E\n"})
final class StreamPlayExtractor$invokeAnichi$2$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ Map<String, String> $headers;
    final /* synthetic */ String $lang;
    final /* synthetic */ SourceUrl $source;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
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
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreamPlayExtractor$invokeAnichi$2$1$1(SourceUrl sourceUrl, String str, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Map<String, String> map, Continuation<? super StreamPlayExtractor$invokeAnichi$2$1$1> continuation) {
        super(1, continuation);
        this.$source = sourceUrl;
        this.$lang = str;
        this.$subtitleCallback = function1;
        this.$callback = function2;
        this.$headers = map;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new StreamPlayExtractor$invokeAnichi$2$1$1(this.$source, this.$lang, this.$subtitleCallback, this.$callback, this.$headers, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x069c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:101:0x069d  */
    /* JADX WARN: Code duplicated, block: B:105:0x06b8 A[LOOP:2: B:103:0x06b2->B:105:0x06b8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:107:0x06db  */
    /* JADX WARN: Code duplicated, block: B:109:0x06e1  */
    /* JADX WARN: Code duplicated, block: B:132:0x07f3  */
    /* JADX WARN: Code duplicated, block: B:53:0x0336 A[Catch: Exception -> 0x0813, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x0813, blocks: (B:40:0x0305, B:46:0x0326, B:53:0x0336, B:45:0x0321, B:42:0x030a), top: B:159:0x0305, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x035d  */
    /* JADX WARN: Code duplicated, block: B:59:0x0392  */
    /* JADX WARN: Code duplicated, block: B:72:0x045c  */
    /* JADX WARN: Code duplicated, block: B:74:0x04ee A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:75:0x04ef  */
    /* JADX WARN: Code duplicated, block: B:77:0x0513  */
    /* JADX WARN: Code duplicated, block: B:79:0x051e  */
    /* JADX WARN: Code duplicated, block: B:81:0x05b2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:82:0x05b3  */
    /* JADX WARN: Code duplicated, block: B:84:0x05d9  */
    /* JADX WARN: Code duplicated, block: B:86:0x05e5  */
    /* JADX WARN: Code duplicated, block: B:88:0x0605  */
    /* JADX WARN: Code duplicated, block: B:89:0x0607  */
    /* JADX WARN: Code duplicated, block: B:91:0x060a  */
    /* JADX WARN: Code duplicated, block: B:92:0x060f  */
    /* JADX WARN: Code duplicated, block: B:95:0x0642  */
    /* JADX WARN: Code duplicated, block: B:97:0x0648  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x06c4 -> B:133:0x0800). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x06e1 -> B:110:0x06f5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:128:0x079d -> B:129:0x07c1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:132:0x07f3 -> B:133:0x0800). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x042c -> B:133:0x0800). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public final java.lang.Object invokeSuspend(java.lang.Object r40) {
        /*
            Method dump skipped, instruction units count: 2244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.StreamPlayExtractor$invokeAnichi$2$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
