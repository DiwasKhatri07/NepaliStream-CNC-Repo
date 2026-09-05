package com.Anichi;

import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AnichiExtractors.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Anichi/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.Anichi.AnichiExtractors$invokeInternalSources$2$4$1", f = "AnichiExtractors.kt", i = {1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, l = {165, 269, 272}, m = "invokeSuspend", n = {"downloadUrl", "downloadId", "sourcename", "clockApi", "downloadUrl", "downloadId", "sourcename", "clockApi", "downloads", "$this$forEach$iv", "element$iv", "item"}, nl = {262, 985, 271}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$9", "L$10"}, v = 2)
@SourceDebugExtension({"SMAP\nAnichiExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnichiExtractors.kt\ncom/Anichi/AnichiExtractors$invokeInternalSources$2$4$1\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,984:1\n73#2,5:985\n2068#3,2:990\n*S KotlinDebug\n*F\n+ 1 AnichiExtractors.kt\ncom/Anichi/AnichiExtractors$invokeInternalSources$2$4$1\n*L\n269#1:985,5\n270#1:990,2\n*E\n"})
final class AnichiExtractors$invokeInternalSources$2$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ String $dubStatus;
    final /* synthetic */ AnichiParser.SourceUrls $source;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
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
    AnichiExtractors$invokeInternalSources$2$4$1(AnichiParser.SourceUrls sourceUrls, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, String str, Continuation<? super AnichiExtractors$invokeInternalSources$2$4$1> continuation) {
        super(2, continuation);
        this.$source = sourceUrls;
        this.$subtitleCallback = function1;
        this.$callback = function2;
        this.$dubStatus = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnichiExtractors$invokeInternalSources$2$4$1(this.$source, this.$subtitleCallback, this.$callback, this.$dubStatus, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.Anichi.AnichiExtractors$invokeInternalSources$2$4$1$1 */
    /* JADX INFO: compiled from: AnichiExtractors.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Anichi.AnichiExtractors$invokeInternalSources$2$4$1$1", f = "AnichiExtractors.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7}, l = {173, 180, 199, 209, 217, 228, 245, 252}, m = "invokeSuspend", n = {"rawLink", "link", "fixedLink", "rawLink", "link", "fixedLink", "rawLink", "link", "decodedlink", "fixedLink", "rawLink", "link", "decodedlink", "fixedLink", "links", "$this$forEach$iv", "element$iv", "server", "host", "rawLink", "link", "decodedlink", "fixedLink", "links", "$this$forEach$iv", "element$iv", "server", "host", "rawLink", "link", "decodedlink", "fixedLink", "links", "$this$forEach$iv", "element$iv", "server", "host", "rawLink", "link", "decodedlink", "fixedLink", "links", "$this$forEach$iv", "element$iv", "server", "host", "endpoint", "rawLink", "link", "decodedlink", "fixedLink", "links", "$this$forEach$iv", "element$iv", "server", "host", "$this$forEach$iv", "element$iv", "sub", "src", "lang"}, nl = {180, 192, 985, 213, 226, 227, 993, 253}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$10", "L$11", "L$12", "L$13", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$10", "L$11", "L$12", "L$13", "L$15", "L$16", "L$17", "L$18"}, v = 2)
    @SourceDebugExtension({"SMAP\nAnichiExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnichiExtractors.kt\ncom/Anichi/AnichiExtractors$invokeInternalSources$2$4$1$1\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,984:1\n73#2,5:985\n2068#3:990\n2068#3,2:991\n2068#3,2:993\n2068#3,2:995\n2069#3:997\n*S KotlinDebug\n*F\n+ 1 AnichiExtractors.kt\ncom/Anichi/AnichiExtractors$invokeInternalSources$2$4$1$1\n*L\n199#1:985,5\n204#1:990\n213#1:991,2\n245#1:993,2\n249#1:995,2\n204#1:997\n*E\n"})
    static final class C00111 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ AnichiParser.SourceUrls $source;
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
        C00111(AnichiParser.SourceUrls sourceUrls, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00111> continuation) {
            super(1, continuation);
            this.$source = sourceUrls;
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00111(this.$source, this.$subtitleCallback, this.$callback, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:100:0x05f0  */
        /* JADX WARN: Code duplicated, block: B:102:0x060f  */
        /* JADX WARN: Code duplicated, block: B:103:0x0611  */
        /* JADX WARN: Code duplicated, block: B:105:0x0614  */
        /* JADX WARN: Code duplicated, block: B:106:0x0619  */
        /* JADX WARN: Code duplicated, block: B:109:0x064c  */
        /* JADX WARN: Code duplicated, block: B:111:0x0652  */
        /* JADX WARN: Code duplicated, block: B:114:0x06a9 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:115:0x06aa  */
        /* JADX WARN: Code duplicated, block: B:119:0x06c5 A[LOOP:2: B:117:0x06bf->B:119:0x06c5, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:121:0x06eb  */
        /* JADX WARN: Code duplicated, block: B:123:0x06f1  */
        /* JADX WARN: Code duplicated, block: B:146:0x07fd  */
        /* JADX WARN: Code duplicated, block: B:58:0x0338  */
        /* JADX WARN: Code duplicated, block: B:60:0x0357  */
        /* JADX WARN: Code duplicated, block: B:62:0x0371  */
        /* JADX WARN: Code duplicated, block: B:66:0x037e  */
        /* JADX WARN: Code duplicated, block: B:81:0x043f  */
        /* JADX WARN: Code duplicated, block: B:84:0x0451  */
        /* JADX WARN: Code duplicated, block: B:86:0x0455  */
        /* JADX WARN: Code duplicated, block: B:88:0x04d8 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:89:0x04d9  */
        /* JADX WARN: Code duplicated, block: B:91:0x0500  */
        /* JADX WARN: Code duplicated, block: B:93:0x050d  */
        /* JADX WARN: Code duplicated, block: B:95:0x05bb A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:96:0x05bc  */
        /* JADX WARN: Code duplicated, block: B:98:0x05e4  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:120:0x06d1 -> B:147:0x080d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:123:0x06f1 -> B:124:0x0700). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:142:0x07b3 -> B:143:0x07cb). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:146:0x07fd -> B:147:0x080d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x041f -> B:147:0x080d). Please report as a decompilation issue!!! */
        /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
            java.lang.StackOverflowError
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
            */
        public final java.lang.Object invokeSuspend(java.lang.Object r37) {
            /*
                Method dump skipped, instruction units count: 2282
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.Anichi.AnichiExtractors$invokeInternalSources$2$4$1.C00111.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Code duplicated, block: B:57:0x0198 A[Catch: Exception -> 0x0282, TRY_LEAVE, TryCatch #6 {Exception -> 0x0282, blocks: (B:55:0x0192, B:57:0x0198), top: B:91:0x0192 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x0247 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:62:0x0248  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x0248 -> B:80:0x025a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public final java.lang.Object invokeSuspend(java.lang.Object r35) {
        /*
            Method dump skipped, instruction units count: 692
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.Anichi.AnichiExtractors$invokeInternalSources$2$4$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
