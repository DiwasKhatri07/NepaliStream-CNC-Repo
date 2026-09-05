package com.phisher98;

import com.lagradost.cloudstream3.utils.ExtractorApi;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/phisher98/Filesdl;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/phisher98/Filesdl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,4003:1\n2068#2,2:4004\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/phisher98/Filesdl\n*L\n2839#1:4004,2\n*E\n"})
public final class Filesdl extends ExtractorApi {

    @NotNull
    private static final Regex QUALITY_REGEX = new Regex("(\\d{3,4}p)", RegexOption.IGNORE_CASE);

    @NotNull
    private final String name = "Filesdl";

    @NotNull
    private final String mainUrl = "https://*.filesdl.site";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.phisher98.Filesdl$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Filesdl", f = "Extractors.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7}, l = {2835, 2846, 2850, 2854, 2859, 2874, 2890, 2900}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "url", "referer", "subtitleCallback", "callback", "doc", "quality", "$this$forEach$iv", "element$iv", "element", "source", "href", "inferredQuality", "url", "referer", "subtitleCallback", "callback", "doc", "quality", "$this$forEach$iv", "element$iv", "element", "source", "href", "inferredQuality", "url", "referer", "subtitleCallback", "callback", "doc", "quality", "$this$forEach$iv", "element$iv", "element", "source", "href", "inferredQuality", "url", "referer", "subtitleCallback", "callback", "doc", "quality", "$this$forEach$iv", "element$iv", "element", "source", "href", "inferredQuality", "url", "referer", "subtitleCallback", "callback", "doc", "quality", "$this$forEach$iv", "element$iv", "element", "source", "href", "inferredQuality", "url", "referer", "subtitleCallback", "callback", "doc", "quality", "$this$forEach$iv", "element$iv", "element", "source", "href", "res", "finalUrl", "redirectUrl", "inferredQuality", "url", "referer", "subtitleCallback", "callback", "doc", "quality", "$this$forEach$iv", "element$iv", "element", "source", "href", "res", "finalUrl", "redirectUrl", "inferredQuality"}, nl = {2837, 2849, 2853, 2857, 2858, 2879, 2889, 2910}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "L$11", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "L$11", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "L$11", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "L$11", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "L$11", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "L$11", "L$13", "L$14", "L$15", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "I$0"}, v = 2)
    static final class C00201 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
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

        C00201(Continuation<? super C00201> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Filesdl.this.getUrl(null, null, null, null, (Continuation) this);
        }
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x07eb  */
    /* JADX WARN: Code duplicated, block: B:102:0x085a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:103:0x085b  */
    /* JADX WARN: Code duplicated, block: B:38:0x03ad  */
    /* JADX WARN: Code duplicated, block: B:40:0x03dd  */
    /* JADX WARN: Code duplicated, block: B:42:0x043f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x0440  */
    /* JADX WARN: Code duplicated, block: B:45:0x0454  */
    /* JADX WARN: Code duplicated, block: B:47:0x0467  */
    /* JADX WARN: Code duplicated, block: B:49:0x04c5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:50:0x04c6  */
    /* JADX WARN: Code duplicated, block: B:52:0x04da  */
    /* JADX WARN: Code duplicated, block: B:54:0x04e8  */
    /* JADX WARN: Code duplicated, block: B:56:0x0549 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:57:0x054a  */
    /* JADX WARN: Code duplicated, block: B:59:0x055e  */
    /* JADX WARN: Code duplicated, block: B:61:0x056f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x05aa -> B:105:0x0871). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:91:0x0710 -> B:92:0x071e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getUrl(@org.jetbrains.annotations.NotNull java.lang.String r45, @org.jetbrains.annotations.Nullable java.lang.String r46, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r47, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r48, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r49) {
        /*
            Method dump skipped, instruction units count: 2192
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.Filesdl.getUrl(java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
