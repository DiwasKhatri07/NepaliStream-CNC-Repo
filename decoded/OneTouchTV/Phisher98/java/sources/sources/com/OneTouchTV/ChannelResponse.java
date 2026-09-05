package com.OneTouchTV;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: OneTouchTVParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/OneTouchTV/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J,\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/OneTouchTV/ChannelResponse;", "", "count", "", "channels", "", "Lcom/OneTouchTV/ChannelItem;", "<init>", "(Ljava/lang/Integer;Ljava/util/List;)V", "getCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getChannels", "()Ljava/util/List;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/util/List;)Lcom/OneTouchTV/ChannelResponse;", "equals", "", "other", "hashCode", "toString", "", "OneTouchTV"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class ChannelResponse {

    @Nullable
    private final List<ChannelItem> channels;

    @Nullable
    private final Integer count;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChannelResponse copy$default(ChannelResponse channelResponse, Integer num, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            num = channelResponse.count;
        }
        if ((i & 2) != 0) {
            list = channelResponse.channels;
        }
        return channelResponse.copy(num, list);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getCount() {
        return this.count;
    }

    @Nullable
    public final List<ChannelItem> component2() {
        return this.channels;
    }

    @NotNull
    public final ChannelResponse copy(@Nullable Integer count, @Nullable List<ChannelItem> channels) {
        return new ChannelResponse(count, channels);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelResponse)) {
            return false;
        }
        ChannelResponse channelResponse = (ChannelResponse) other;
        return Intrinsics.areEqual(this.count, channelResponse.count) && Intrinsics.areEqual(this.channels, channelResponse.channels);
    }

    public int hashCode() {
        return ((this.count == null ? 0 : this.count.hashCode()) * 31) + (this.channels != null ? this.channels.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ChannelResponse(count=" + this.count + ", channels=" + this.channels + ')';
    }

    public ChannelResponse(@Nullable Integer count, @Nullable List<ChannelItem> list) {
        this.count = count;
        this.channels = list;
    }

    @Nullable
    public final Integer getCount() {
        return this.count;
    }

    @Nullable
    public final List<ChannelItem> getChannels() {
        return this.channels;
    }
}
