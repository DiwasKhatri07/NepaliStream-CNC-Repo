package com.cncverse;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LivXowProviderManager.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/LivXowProvider/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/cncverse/LivXowChannelWrapper;", "", "channel", "", "highlight", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getChannel", "()Ljava/lang/String;", "getHighlight", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "LivXowProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class LivXowChannelWrapper {

    @NotNull
    private final String channel;

    @NotNull
    private final String highlight;

    /* JADX WARN: Illegal instructions before constructor call */
    public LivXowChannelWrapper() {
        String str = null;
        this(str, str, 3, str);
    }

    public static /* synthetic */ LivXowChannelWrapper copy$default(LivXowChannelWrapper livXowChannelWrapper, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = livXowChannelWrapper.channel;
        }
        if ((i & 2) != 0) {
            str2 = livXowChannelWrapper.highlight;
        }
        return livXowChannelWrapper.copy(str, str2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getChannel() {
        return this.channel;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getHighlight() {
        return this.highlight;
    }

    @NotNull
    public final LivXowChannelWrapper copy(@NotNull String channel, @NotNull String highlight) {
        return new LivXowChannelWrapper(channel, highlight);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LivXowChannelWrapper)) {
            return false;
        }
        LivXowChannelWrapper livXowChannelWrapper = (LivXowChannelWrapper) other;
        return Intrinsics.areEqual(this.channel, livXowChannelWrapper.channel) && Intrinsics.areEqual(this.highlight, livXowChannelWrapper.highlight);
    }

    public int hashCode() {
        return (this.channel.hashCode() * 31) + this.highlight.hashCode();
    }

    @NotNull
    public String toString() {
        return "LivXowChannelWrapper(channel=" + this.channel + ", highlight=" + this.highlight + ')';
    }

    public LivXowChannelWrapper(@NotNull String channel, @NotNull String highlight) {
        this.channel = channel;
        this.highlight = highlight;
    }

    public /* synthetic */ LivXowChannelWrapper(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }

    @NotNull
    public final String getChannel() {
        return this.channel;
    }

    @NotNull
    public final String getHighlight() {
        return this.highlight;
    }
}
