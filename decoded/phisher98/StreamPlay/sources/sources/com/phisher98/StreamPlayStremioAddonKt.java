package com.phisher98;

import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.SubtitleFile;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayStremioAddon.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\u001aV\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\nH\u0086@¢\u0006\u0002\u0010\f\u001aj\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\n2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\nH\u0086@¢\u0006\u0002\u0010\u0010\u001aV\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\nH\u0086@¢\u0006\u0002\u0010\f\u001a*\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\nH\u0082@¢\u0006\u0002\u0010\u0015\u001a\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H\u0002\u001a$\u0010\u0019\u001a\u0004\u0018\u00010\u0003*\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0003H\u0002¨\u0006\u001c"}, d2 = {"invokeStremioTorrentsGlobal", "", "sourceName", "", "api", "imdbId", "season", "", "episode", "callback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeStreamioStreamsGlobal", "subtitleCallback", "Lcom/lagradost/cloudstream3/SubtitleFile;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeStremioSubtitlesGlobal", "emitStremioSubtitle", "subtitle", "Lcom/phisher98/StreamPlayStremioSubtitle;", "(Lcom/phisher98/StreamPlayStremioSubtitle;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildMagnetString", "stream", "Lcom/phisher98/StreamPlayStremioStream;", "getHeader", "", "name", "StreamPlay"}, k = 2, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStreamPlayStremioAddon.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayStremioAddon.kt\ncom/phisher98/StreamPlayStremioAddonKt\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,239:1\n73#2,5:240\n73#2,5:248\n73#2,5:257\n2068#3:245\n2069#3:247\n2068#3:253\n2068#3,2:254\n2069#3:256\n2068#3,2:262\n777#3:264\n873#3,2:265\n1739#3:267\n1814#3,3:268\n777#3:271\n873#3,2:272\n2068#3,2:274\n296#3,2:276\n1#4:246\n*S KotlinDebug\n*F\n+ 1 StreamPlayStremioAddon.kt\ncom/phisher98/StreamPlayStremioAddonKt\n*L\n106#1:240,5\n138#1:248,5\n190#1:257,5\n108#1:245\n108#1:247\n140#1:253\n174#1:254,2\n140#1:256\n191#1:262,2\n210#1:264\n210#1:265,2\n211#1:267\n211#1:268,3\n212#1:271\n212#1:272,2\n213#1:274,2\n218#1:276,2\n*E\n"})
public final class StreamPlayStremioAddonKt {

    /* JADX INFO: renamed from: com.phisher98.StreamPlayStremioAddonKt$emitStremioSubtitle$1 */
    /* JADX INFO: compiled from: StreamPlayStremioAddon.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayStremioAddonKt", f = "StreamPlayStremioAddon.kt", i = {0, 0, 0, 0}, l = {197}, m = "emitStremioSubtitle", n = {"subtitle", "subtitleCallback", "lang", "fileUrl"}, nl = {198}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 2)
    static final class C02511 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C02511(Continuation<? super C02511> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayStremioAddonKt.emitStremioSubtitle(null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayStremioAddonKt$invokeStreamioStreamsGlobal$1 */
    /* JADX INFO: compiled from: StreamPlayStremioAddon.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayStremioAddonKt", f = "StreamPlayStremioAddon.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {138, 156, 172, 173, 174}, m = "invokeStreamioStreamsGlobal", n = {"sourceName", "api", "imdbId", "season", "episode", "subtitleCallback", "callback", "url", "timeout", "sourceName", "api", "imdbId", "season", "episode", "subtitleCallback", "callback", "url", "res", "$this$forEach$iv", "element$iv", "s", "streamUrl", "type", "proxyReq", "title", "stdHeaders", "timeout", "sourceName", "api", "imdbId", "season", "episode", "subtitleCallback", "callback", "url", "res", "$this$forEach$iv", "element$iv", "s", "streamUrl", "title", "it", "timeout", "sourceName", "api", "imdbId", "season", "episode", "subtitleCallback", "callback", "url", "res", "$this$forEach$iv", "element$iv", "s", "streamUrl", "title", "it", "timeout", "sourceName", "api", "imdbId", "season", "episode", "subtitleCallback", "callback", "url", "res", "$this$forEach$iv", "element$iv", "s", "streamUrl", "$this$forEach$iv", "title", "element$iv", "it", "timeout"}, nl = {240, 155, 172, 173, 247}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "L$14", "L$15", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "L$14", "L$15", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "L$14", "L$15", "L$17", "L$18", "J$0"}, v = 2)
    static final class C02521 extends ContinuationImpl {
        long J$0;
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
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C02521(Continuation<? super C02521> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayStremioAddonKt.invokeStreamioStreamsGlobal(null, null, null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayStremioAddonKt$invokeStremioSubtitlesGlobal$1 */
    /* JADX INFO: compiled from: StreamPlayStremioAddon.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayStremioAddonKt", f = "StreamPlayStremioAddon.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {190, 191}, m = "invokeStremioSubtitlesGlobal", n = {"sourceName", "api", "imdbId", "season", "episode", "subtitleCallback", "url", "timeout", "sourceName", "api", "imdbId", "season", "episode", "subtitleCallback", "url", "subtitleResponse", "$this$forEach$iv", "element$iv", "it", "timeout"}, nl = {240, 245}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "J$0"}, v = 2)
    static final class C02531 extends ContinuationImpl {
        long J$0;
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
        /* synthetic */ Object result;

        C02531(Continuation<? super C02531> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayStremioAddonKt.invokeStremioSubtitlesGlobal(null, null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayStremioAddonKt$invokeStremioTorrentsGlobal$1 */
    /* JADX INFO: compiled from: StreamPlayStremioAddon.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayStremioAddonKt", f = "StreamPlayStremioAddon.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {106, 113}, m = "invokeStremioTorrentsGlobal", n = {"sourceName", "api", "imdbId", "season", "episode", "callback", "url", "timeout", "sourceName", "api", "imdbId", "season", "episode", "callback", "url", "res", "$this$forEach$iv", "element$iv", "stream", "magnet", "title", "timeout"}, nl = {240, 112}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "L$12", "L$13", "J$0"}, v = 2)
    static final class C02541 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C02541(Continuation<? super C02541> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayStremioAddonKt.invokeStremioTorrentsGlobal(null, null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x020a  */
    /* JADX WARN: Code duplicated, block: B:46:0x021a  */
    /* JADX WARN: Code duplicated, block: B:54:0x023d  */
    /* JADX WARN: Code duplicated, block: B:56:0x0241  */
    /* JADX WARN: Code duplicated, block: B:57:0x0248  */
    /* JADX WARN: Code duplicated, block: B:59:0x02f0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:60:0x02f1  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x0241 -> B:62:0x0316). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x02f1 -> B:61:0x0309). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object invokeStremioTorrentsGlobal(@org.jetbrains.annotations.NotNull java.lang.String r25, @org.jetbrains.annotations.NotNull java.lang.String r26, @org.jetbrains.annotations.Nullable java.lang.String r27, @org.jetbrains.annotations.Nullable java.lang.Integer r28, @org.jetbrains.annotations.Nullable java.lang.Integer r29, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r30, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r31) {
        /*
            Method dump skipped, instruction units count: 832
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.StreamPlayStremioAddonKt.invokeStremioTorrentsGlobal(java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object invokeStremioTorrentsGlobal$default(String str, String str2, String str3, Integer num, Integer num2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            num = null;
        }
        if ((i & 16) != 0) {
            num2 = null;
        }
        return invokeStremioTorrentsGlobal(str, str2, str3, num, num2, function1, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:123:0x071f  */
    /* JADX WARN: Code duplicated, block: B:125:0x0796 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:126:0x0797  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:126:0x0797 -> B:127:0x07ba). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object invokeStreamioStreamsGlobal(@org.jetbrains.annotations.NotNull java.lang.String r34, @org.jetbrains.annotations.NotNull java.lang.String r35, @org.jetbrains.annotations.Nullable java.lang.String r36, @org.jetbrains.annotations.Nullable java.lang.Integer r37, @org.jetbrains.annotations.Nullable java.lang.Integer r38, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r39, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r40, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r41) {
        /*
            Method dump skipped, instruction units count: 2084
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.StreamPlayStremioAddonKt.invokeStreamioStreamsGlobal(java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object invokeStreamioStreamsGlobal$default(String str, String str2, String str3, Integer num, Integer num2, Function1 function1, Function1 function2, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            num = null;
        }
        if ((i & 16) != 0) {
            num2 = null;
        }
        return invokeStreamioStreamsGlobal(str, str2, str3, num, num2, function1, function2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:44:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:46:0x0240 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:47:0x0241  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0241 -> B:48:0x0254). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object invokeStremioSubtitlesGlobal(@org.jetbrains.annotations.NotNull java.lang.String r22, @org.jetbrains.annotations.NotNull java.lang.String r23, @org.jetbrains.annotations.Nullable java.lang.String r24, @org.jetbrains.annotations.Nullable java.lang.Integer r25, @org.jetbrains.annotations.Nullable java.lang.Integer r26, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r27, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r28) {
        /*
            Method dump skipped, instruction units count: 640
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.StreamPlayStremioAddonKt.invokeStremioSubtitlesGlobal(java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object invokeStremioSubtitlesGlobal$default(String str, String str2, String str3, Integer num, Integer num2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            num = null;
        }
        if ((i & 16) != 0) {
            num2 = null;
        }
        return invokeStremioSubtitlesGlobal(str, str2, str3, num, num2, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object emitStremioSubtitle(StreamPlayStremioSubtitle subtitle, Function1<? super SubtitleFile, Unit> function1, Continuation<? super Unit> continuation) {
        C02511 c02511;
        Object obj;
        if (continuation instanceof C02511) {
            c02511 = (C02511) continuation;
            if ((c02511.label & Integer.MIN_VALUE) != 0) {
                c02511.label -= Integer.MIN_VALUE;
            } else {
                c02511 = new C02511(continuation);
            }
        } else {
            c02511 = new C02511(continuation);
        }
        C02511 c02512 = c02511;
        Object $result = c02512.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c02512.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String lang = subtitle.getLang();
                if (lang == null && (lang = subtitle.getLangCode()) == null) {
                    return Unit.INSTANCE;
                }
                String lang2 = lang;
                String fileUrl = subtitle.getUrl();
                if (fileUrl == null) {
                    return Unit.INSTANCE;
                }
                String it = StreamPlayUtilsKt.getLanguage(lang2);
                if (Intrinsics.areEqual(it, "UnKnown")) {
                    it = null;
                }
                if (it == null) {
                    it = lang2;
                }
                c02512.L$0 = SpillingKt.nullOutSpilledVariable(subtitle);
                c02512.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c02512.L$2 = SpillingKt.nullOutSpilledVariable(lang2);
                c02512.L$3 = SpillingKt.nullOutSpilledVariable(fileUrl);
                c02512.L$4 = function1;
                c02512.label = 1;
                Object objNewSubtitleFile$default = MainAPIKt.newSubtitleFile$default(it, fileUrl, (Function2) null, c02512, 4, (Object) null);
                if (objNewSubtitleFile$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objNewSubtitleFile$default;
                break;
            case 1:
                Function1<? super SubtitleFile, Unit> function2 = (Function1) c02512.L$4;
                ResultKt.throwOnFailure($result);
                function1 = function2;
                obj = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        function1.invoke(obj);
        return Unit.INSTANCE;
    }

    private static final String buildMagnetString(StreamPlayStremioStream stream) {
        String url = stream.getUrl();
        if (url == null) {
            url = "";
        }
        if (StringsKt.startsWith(url, "magnet:", true)) {
            return url;
        }
        String infoHash = stream.getInfoHash();
        if (infoHash != null) {
            if (StringsKt.isBlank(infoHash)) {
                infoHash = null;
            }
            if (infoHash != null) {
                String title = stream.getDescription();
                if (title == null && (title = stream.getTitle()) == null && (title = stream.getName()) == null) {
                    title = infoHash;
                }
                StringBuilder $this$buildMagnetString_u24lambda_u241 = new StringBuilder();
                $this$buildMagnetString_u24lambda_u241.append("magnet:?xt=urn:btih:").append(infoHash);
                $this$buildMagnetString_u24lambda_u241.append("&dn=").append(URLEncoder.encode(title, StandardCharsets.UTF_8.name()));
                Integer fileIdx = stream.getFileIdx();
                if (fileIdx != null) {
                    int it = fileIdx.intValue();
                    $this$buildMagnetString_u24lambda_u241.append("&so=").append(it);
                }
                Iterable $this$filter$iv = stream.getSources();
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filter$iv) {
                    String it2 = (String) element$iv$iv;
                    if (StringsKt.startsWith(it2, "tracker:", true)) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                Iterable $this$map$iv = (List) destination$iv$iv;
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    String it3 = (String) item$iv$iv;
                    destination$iv$iv2.add(StringsKt.removePrefix(it3, "tracker:"));
                    url = url;
                }
                Iterable $this$filter$iv2 = (List) destination$iv$iv2;
                Collection destination$iv$iv3 = new ArrayList();
                for (Object element$iv$iv2 : $this$filter$iv2) {
                    String it4 = (String) element$iv$iv2;
                    if (!StringsKt.isBlank(it4)) {
                        destination$iv$iv3.add(element$iv$iv2);
                    }
                }
                Iterable $this$forEach$iv = (List) destination$iv$iv3;
                for (Object element$iv : $this$forEach$iv) {
                    String it5 = (String) element$iv;
                    $this$buildMagnetString_u24lambda_u241.append("&tr=").append(URLEncoder.encode(it5, StandardCharsets.UTF_8.name()));
                }
                return $this$buildMagnetString_u24lambda_u241.toString();
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getHeader(Map<String, String> map, String name) {
        Iterable iterableEntrySet;
        Object element$iv;
        Map.Entry it;
        if (map == null || (iterableEntrySet = map.entrySet()) == null) {
            return null;
        }
        Iterable $this$firstOrNull$iv = iterableEntrySet;
        Iterator it2 = $this$firstOrNull$iv.iterator();
        do {
            if (!it2.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it2.next();
            it = (Map.Entry) element$iv;
        } while (!StringsKt.equals((String) it.getKey(), name, true));
        Map.Entry entry = (Map.Entry) element$iv;
        if (entry != null) {
            return (String) entry.getValue();
        }
        return null;
    }
}
