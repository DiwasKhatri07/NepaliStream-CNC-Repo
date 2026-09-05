package com.phisher98;

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
import org.json.JSONArray;

/* JADX INFO: compiled from: StreamPlayExtractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeAnikage$2$1$1", f = "StreamPlayExtractor.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {5582, 5602, 5606, 5625, 5638}, m = "invokeSuspend", n = {"serverObj", "serverId", "providerId", "sourceUrl", "serverObj", "serverId", "providerId", "sourceUrl", "sourceRes", "usedEmbedUrls", "$this$forEach$iv", "element$iv", "source", "encodedUrl", "proxiedUrl", "embedUrl", "proxyHeaders", "isM3U8", "serverObj", "serverId", "providerId", "sourceUrl", "sourceRes", "usedEmbedUrls", "$this$forEach$iv", "element$iv", "source", "encodedUrl", "proxiedUrl", "embedUrl", "proxyHeaders", "isM3U8", "serverObj", "serverId", "providerId", "sourceUrl", "sourceRes", "usedEmbedUrls", "seenSubs", "$this$forEach$iv", "element$iv", "sub", "label", "file", "subUrl", "serverObj", "serverId", "providerId", "sourceUrl", "sourceRes", "usedEmbedUrls", "seenSubs", "$this$forEach$iv", "element$iv", "embed", "typeCap", "embedUrl"}, nl = {6036, 5605, 5605, 5631, 5640}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$11", "L$12", "L$13", "L$14", "L$15", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$12", "L$13", "L$14", "L$15"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor$invokeAnikage$2$1$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,6034:1\n1#2:6035\n73#3,5:6036\n2068#4,2:6041\n2068#4,2:6043\n2068#4,2:6045\n*S KotlinDebug\n*F\n+ 1 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor$invokeAnikage$2$1$1\n*L\n5582#1:6036,5\n5589#1:6041,2\n5620#1:6043,2\n5633#1:6045,2\n*E\n"})
final class StreamPlayExtractor$invokeAnikage$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $anikageAPI;
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ Integer $episode;

    /* JADX INFO: renamed from: $i */
    final /* synthetic */ int f40$i;
    final /* synthetic */ String $lang;
    final /* synthetic */ JSONArray $serversArray;
    final /* synthetic */ String $slug;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
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
    StreamPlayExtractor$invokeAnikage$2$1$1(JSONArray jSONArray, int i, String str, String str2, Integer num, String str3, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super StreamPlayExtractor$invokeAnikage$2$1$1> continuation) {
        super(2, continuation);
        this.$serversArray = jSONArray;
        this.f40$i = i;
        this.$anikageAPI = str;
        this.$slug = str2;
        this.$episode = num;
        this.$lang = str3;
        this.$subtitleCallback = function1;
        this.$callback = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StreamPlayExtractor$invokeAnikage$2$1$1(this.$serversArray, this.f40$i, this.$anikageAPI, this.$slug, this.$episode, this.$lang, this.$subtitleCallback, this.$callback, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:43:0x03a7  */
    /* JADX WARN: Code duplicated, block: B:45:0x03b7  */
    /* JADX WARN: Code duplicated, block: B:46:0x03c6  */
    /* JADX WARN: Code duplicated, block: B:48:0x03ce  */
    /* JADX WARN: Code duplicated, block: B:49:0x03d3  */
    /* JADX WARN: Code duplicated, block: B:52:0x03dd  */
    /* JADX WARN: Code duplicated, block: B:53:0x03e4  */
    /* JADX WARN: Code duplicated, block: B:56:0x0444  */
    /* JADX WARN: Code duplicated, block: B:60:0x044d  */
    /* JADX WARN: Code duplicated, block: B:62:0x0450  */
    /* JADX WARN: Code duplicated, block: B:72:0x0558  */
    /* JADX WARN: Code duplicated, block: B:73:0x055b  */
    /* JADX WARN: Code duplicated, block: B:75:0x055f  */
    /* JADX WARN: Code duplicated, block: B:76:0x05a7  */
    /* JADX WARN: Code duplicated, block: B:79:0x05d7  */
    /* JADX WARN: Code duplicated, block: B:80:0x05d9  */
    /* JADX WARN: Code duplicated, block: B:82:0x05dc  */
    /* JADX WARN: Code duplicated, block: B:83:0x0614  */
    /* JADX WARN: Code duplicated, block: B:86:0x0622  */
    /* JADX WARN: Code duplicated, block: B:87:0x0625  */
    /* JADX WARN: Code duplicated, block: B:90:0x0696 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:91:0x0697  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:112:0x07b7 -> B:113:0x07d1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:144:0x096f -> B:145:0x0982). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x03b7 -> B:93:0x06b5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:91:0x0697 -> B:92:0x06a4). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object invokeSuspend(java.lang.Object r44) {
        /*
            Method dump skipped, instruction units count: 2522
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.StreamPlayExtractor$invokeAnikage$2$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
