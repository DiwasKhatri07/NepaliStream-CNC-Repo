package com.cncverse.desiserials;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DesiSerialsProvider.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/DesiSerialsProvider/classes.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.cncverse.desiserials.DesiSerialsProvider", f = "DesiSerialsProvider.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 15, 15, 15, 15, 15, 15}, l = {280, 300, 320, 338, 352, 357, 367, 379, 382, 387, 397, 409, 412, 416, 427, 439}, m = "loadLinks$handleIframe", n = {"$subtitleCallback", "$callback", "this$0", "href", "referer", "url", "$subtitleCallback", "$callback", "this$0", "href", "referer", "url", "vidResponse", "vidText", "vidDoc", "nestedIframes", "nestedMatches", "$this$forEach$iv", "element$iv", "nestedSrc", "nestedUrl", "fullNestedUrl", "$i$f$forEach", "$i$a$-forEach-DesiSerialsProvider$loadLinks$handleIframe$2", "$subtitleCallback", "$callback", "this$0", "href", "referer", "url", "vidResponse", "vidText", "vidDoc", "nestedIframes", "nestedMatches", "$this$forEach$iv", "element$iv", "nestedSrc", "nestedUrl", "fullNestedUrl", "streamHeaders", "playerHtml", "m3u8Regex", "m3u8Links", "$this$forEach$iv", "element$iv", "source", "$i$f$forEach", "$i$a$-forEach-DesiSerialsProvider$loadLinks$handleIframe$2", "$i$f$forEach", "$i$a$-forEach-DesiSerialsProvider$loadLinks$handleIframe$2$1", "$subtitleCallback", "$callback", "this$0", "href", "referer", "url", "vidResponse", "vidText", "vidDoc", "nestedIframes", "nestedMatches", "$this$forEach$iv", "element$iv", "nestedSrc", "nestedUrl", "fullNestedUrl", "streamHeaders", "playerHtml", "m3u8Regex", "m3u8Links", "mp4Regex", "mp4Links", "$this$forEach$iv", "element$iv", "source", "$i$f$forEach", "$i$a$-forEach-DesiSerialsProvider$loadLinks$handleIframe$2", "$i$f$forEach", "$i$a$-forEach-DesiSerialsProvider$loadLinks$handleIframe$2$2", "$subtitleCallback", "$callback", "this$0", "href", "referer", "url", "vidResponse", "vidText", "vidDoc", "nestedIframes", "nestedMatches", "$this$forEach$iv", "element$iv", "nestedSrc", "nestedUrl", "fullNestedUrl", "e", "$i$f$forEach", "$i$a$-forEach-DesiSerialsProvider$loadLinks$handleIframe$2", "$subtitleCallback", "$callback", "this$0", "href", "referer", "url", "vidResponse", "vidText", "vidDoc", "nestedIframes", "nestedMatches", "$this$forEach$iv", "element$iv", "nestedSrc", "nestedUrl", "fullNestedUrl", "$i$f$forEach", "$i$a$-forEach-DesiSerialsProvider$loadLinks$handleIframe$2", "$subtitleCallback", "$callback", "this$0", "href", "referer", "url", "vidResponse", "vidText", "vidDoc", "nestedIframes", "nestedMatches", "$this$forEach$iv", "element$iv", "nestedSrc", "nestedUrl", "fullNestedUrl", "base64Match", "playerHtml", "base64Code", "decodedStr", "unpacked", "m3u8Regex", "m3u8Links", "$this$forEach$iv", "element$iv", "source", "$i$f$forEach", "$i$a$-forEach-DesiSerialsProvider$loadLinks$handleIframe$2", "$i$f$forEach", "$i$a$-forEach-DesiSerialsProvider$loadLinks$handleIframe$2$3", "$subtitleCallback", "$callback", "this$0", "href", "referer", "url", "vidResponse", "vidText", "vidDoc", "nestedIframes", "nestedMatches", "$this$forEach$iv", "element$iv", "nestedSrc", "nestedUrl", "fullNestedUrl", "base64Match", "playerHtml", "$i$f$forEach", "$i$a$-forEach-DesiSerialsProvider$loadLinks$handleIframe$2", "$subtitleCallback", "$callback", "this$0", "href", "referer", "url", "vidResponse", "vidText", "vidDoc", "nestedIframes", "nestedMatches", "$this$forEach$iv", "element$iv", "nestedSrc", "nestedUrl", "fullNestedUrl", "e", "$i$f$forEach", "$i$a$-forEach-DesiSerialsProvider$loadLinks$handleIframe$2", "$subtitleCallback", "$callback", "this$0", "href", "referer", "url", "vidResponse", "vidText", "vidDoc", "nestedIframes", "nestedMatches", "$this$forEach$iv", "element$iv", "nestedSrc", "nestedUrl", "fullNestedUrl", "$i$f$forEach", "$i$a$-forEach-DesiSerialsProvider$loadLinks$handleIframe$2", "$subtitleCallback", "$callback", "this$0", "href", "referer", "url", "vidResponse", "vidText", "vidDoc", "nestedIframes", "nestedMatches", "$this$forEach$iv", "element$iv", "nestedSrc", "nestedUrl", "fullNestedUrl", "unpacked", "playerHtml", "videoRegex", "videoLinks", "$this$forEach$iv", "element$iv", "source", "$i$f$forEach", "$i$a$-forEach-DesiSerialsProvider$loadLinks$handleIframe$2", "$i$f$forEach", "$i$a$-forEach-DesiSerialsProvider$loadLinks$handleIframe$2$4", "isM3u8", "$subtitleCallback", "$callback", "this$0", "href", "referer", "url", "vidResponse", "vidText", "vidDoc", "nestedIframes", "nestedMatches", "$this$forEach$iv", "element$iv", "nestedSrc", "nestedUrl", "fullNestedUrl", "unpacked", "playerHtml", "videoRegex", "videoLinks", "$i$f$forEach", "$i$a$-forEach-DesiSerialsProvider$loadLinks$handleIframe$2", "$subtitleCallback", "$callback", "this$0", "href", "referer", "url", "vidResponse", "vidText", "vidDoc", "nestedIframes", "nestedMatches", "$this$forEach$iv", "element$iv", "nestedSrc", "nestedUrl", "fullNestedUrl", "e", "$i$f$forEach", "$i$a$-forEach-DesiSerialsProvider$loadLinks$handleIframe$2", "$subtitleCallback", "$callback", "this$0", "href", "referer", "url", "vidResponse", "vidText", "vidDoc", "nestedIframes", "nestedMatches", "$this$forEach$iv", "element$iv", "nestedSrc", "nestedUrl", "fullNestedUrl", "$i$f$forEach", "$i$a$-forEach-DesiSerialsProvider$loadLinks$handleIframe$2", "$subtitleCallback", "$callback", "this$0", "href", "referer", "url", "vidResponse", "vidText", "vidDoc", "nestedIframes", "nestedMatches", "videoRegex", "sources", "$this$forEach$iv", "element$iv", "source", "$i$f$forEach", "$i$a$-forEach-DesiSerialsProvider$loadLinks$handleIframe$3", "isM3u8", "$subtitleCallback", "$callback", "this$0", "href", "referer", "url"}, nl = {284, 303, 319, 337, 354, 358, 366, 381, 384, 388, 396, 411, 416, 418, 426, 441}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$13", "L$14", "L$15", "L$16", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$23", "L$24", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$25", "L$26", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$13", "L$14", "L$15", "L$16", "L$17", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$13", "L$14", "L$15", "L$16", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$26", "L$27", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$13", "L$14", "L$15", "L$16", "L$17", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$13", "L$14", "L$15", "L$16", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$23", "L$24", "I$0", "I$1", "I$2", "I$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$13", "L$14", "L$15", "L$16", "L$17", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$13", "L$14", "L$15", "L$16", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$15", "L$16", "I$0", "I$1", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
final class DesiSerialsProvider$loadLinks$handleIframe$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
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
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    DesiSerialsProvider$loadLinks$handleIframe$1(Continuation<? super DesiSerialsProvider$loadLinks$handleIframe$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DesiSerialsProvider.loadLinks$handleIframe(null, null, null, null, null, (Continuation) this);
    }
}
