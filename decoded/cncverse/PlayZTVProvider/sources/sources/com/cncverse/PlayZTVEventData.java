package com.cncverse;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PlayZTVProviderManager.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/PlayZTVProvider/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b-\b\u0086\b\u0018\u00002\u00020\u0001B£\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u00108\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010HÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010:\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010*JÈ\u0001\u0010;\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u0010<J\u0014\u0010=\u001a\u00020\u00122\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010?\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010@\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*¨\u0006A"}, d2 = {"Lcom/cncverse/PlayZTVEventData;", "", "category", "", "eventName", "eventLogo", "teamAName", "teamBName", "teamAFlag", "teamBFlag", "date", "time", "end_date", "end_time", "links", "link_names", "", "visible", "", "priority", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getCategory", "()Ljava/lang/String;", "getEventName", "getEventLogo", "getTeamAName", "getTeamBName", "getTeamAFlag", "getTeamBFlag", "getDate", "getTime", "getEnd_date", "getEnd_time", "getLinks", "getLink_names", "()Ljava/util/List;", "getVisible", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPriority", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/cncverse/PlayZTVEventData;", "equals", "other", "hashCode", "toString", "PlayZTVProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class PlayZTVEventData {

    @Nullable
    private final String category;

    @Nullable
    private final String date;

    @Nullable
    private final String end_date;

    @Nullable
    private final String end_time;

    @Nullable
    private final String eventLogo;

    @Nullable
    private final String eventName;

    @Nullable
    private final List<String> link_names;

    @Nullable
    private final String links;

    @Nullable
    private final Integer priority;

    @Nullable
    private final String teamAFlag;

    @Nullable
    private final String teamAName;

    @Nullable
    private final String teamBFlag;

    @Nullable
    private final String teamBName;

    @Nullable
    private final String time;

    @Nullable
    private final Boolean visible;

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getEnd_date() {
        return this.end_date;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getEnd_time() {
        return this.end_time;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getLinks() {
        return this.links;
    }

    @Nullable
    public final List<String> component13() {
        return this.link_names;
    }

    @Nullable
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Boolean getVisible() {
        return this.visible;
    }

    @Nullable
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final Integer getPriority() {
        return this.priority;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEventName() {
        return this.eventName;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getEventLogo() {
        return this.eventLogo;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTeamAName() {
        return this.teamAName;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTeamBName() {
        return this.teamBName;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getTeamAFlag() {
        return this.teamAFlag;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getTeamBFlag() {
        return this.teamBFlag;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getTime() {
        return this.time;
    }

    @NotNull
    public final PlayZTVEventData copy(@Nullable String category, @Nullable String eventName, @Nullable String eventLogo, @Nullable String teamAName, @Nullable String teamBName, @Nullable String teamAFlag, @Nullable String teamBFlag, @Nullable String date, @Nullable String time, @Nullable String end_date, @Nullable String end_time, @Nullable String links, @Nullable List<String> link_names, @Nullable Boolean visible, @Nullable Integer priority) {
        return new PlayZTVEventData(category, eventName, eventLogo, teamAName, teamBName, teamAFlag, teamBFlag, date, time, end_date, end_time, links, link_names, visible, priority);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayZTVEventData)) {
            return false;
        }
        PlayZTVEventData playZTVEventData = (PlayZTVEventData) other;
        return Intrinsics.areEqual(this.category, playZTVEventData.category) && Intrinsics.areEqual(this.eventName, playZTVEventData.eventName) && Intrinsics.areEqual(this.eventLogo, playZTVEventData.eventLogo) && Intrinsics.areEqual(this.teamAName, playZTVEventData.teamAName) && Intrinsics.areEqual(this.teamBName, playZTVEventData.teamBName) && Intrinsics.areEqual(this.teamAFlag, playZTVEventData.teamAFlag) && Intrinsics.areEqual(this.teamBFlag, playZTVEventData.teamBFlag) && Intrinsics.areEqual(this.date, playZTVEventData.date) && Intrinsics.areEqual(this.time, playZTVEventData.time) && Intrinsics.areEqual(this.end_date, playZTVEventData.end_date) && Intrinsics.areEqual(this.end_time, playZTVEventData.end_time) && Intrinsics.areEqual(this.links, playZTVEventData.links) && Intrinsics.areEqual(this.link_names, playZTVEventData.link_names) && Intrinsics.areEqual(this.visible, playZTVEventData.visible) && Intrinsics.areEqual(this.priority, playZTVEventData.priority);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((this.category == null ? 0 : this.category.hashCode()) * 31) + (this.eventName == null ? 0 : this.eventName.hashCode())) * 31) + (this.eventLogo == null ? 0 : this.eventLogo.hashCode())) * 31) + (this.teamAName == null ? 0 : this.teamAName.hashCode())) * 31) + (this.teamBName == null ? 0 : this.teamBName.hashCode())) * 31) + (this.teamAFlag == null ? 0 : this.teamAFlag.hashCode())) * 31) + (this.teamBFlag == null ? 0 : this.teamBFlag.hashCode())) * 31) + (this.date == null ? 0 : this.date.hashCode())) * 31) + (this.time == null ? 0 : this.time.hashCode())) * 31) + (this.end_date == null ? 0 : this.end_date.hashCode())) * 31) + (this.end_time == null ? 0 : this.end_time.hashCode())) * 31) + (this.links == null ? 0 : this.links.hashCode())) * 31) + (this.link_names == null ? 0 : this.link_names.hashCode())) * 31) + (this.visible == null ? 0 : this.visible.hashCode())) * 31) + (this.priority != null ? this.priority.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PlayZTVEventData(category=").append(this.category).append(", eventName=").append(this.eventName).append(", eventLogo=").append(this.eventLogo).append(", teamAName=").append(this.teamAName).append(", teamBName=").append(this.teamBName).append(", teamAFlag=").append(this.teamAFlag).append(", teamBFlag=").append(this.teamBFlag).append(", date=").append(this.date).append(", time=").append(this.time).append(", end_date=").append(this.end_date).append(", end_time=").append(this.end_time).append(", links=");
        sb.append(this.links).append(", link_names=").append(this.link_names).append(", visible=").append(this.visible).append(", priority=").append(this.priority).append(')');
        return sb.toString();
    }

    public PlayZTVEventData(@Nullable String category, @Nullable String eventName, @Nullable String eventLogo, @Nullable String teamAName, @Nullable String teamBName, @Nullable String teamAFlag, @Nullable String teamBFlag, @Nullable String date, @Nullable String time, @Nullable String end_date, @Nullable String end_time, @Nullable String links, @Nullable List<String> list, @Nullable Boolean visible, @Nullable Integer priority) {
        this.category = category;
        this.eventName = eventName;
        this.eventLogo = eventLogo;
        this.teamAName = teamAName;
        this.teamBName = teamBName;
        this.teamAFlag = teamAFlag;
        this.teamBFlag = teamBFlag;
        this.date = date;
        this.time = time;
        this.end_date = end_date;
        this.end_time = end_time;
        this.links = links;
        this.link_names = list;
        this.visible = visible;
        this.priority = priority;
    }

    @Nullable
    public final String getCategory() {
        return this.category;
    }

    @Nullable
    public final String getEventName() {
        return this.eventName;
    }

    @Nullable
    public final String getEventLogo() {
        return this.eventLogo;
    }

    @Nullable
    public final String getTeamAName() {
        return this.teamAName;
    }

    @Nullable
    public final String getTeamBName() {
        return this.teamBName;
    }

    @Nullable
    public final String getTeamAFlag() {
        return this.teamAFlag;
    }

    @Nullable
    public final String getTeamBFlag() {
        return this.teamBFlag;
    }

    @Nullable
    public final String getDate() {
        return this.date;
    }

    @Nullable
    public final String getTime() {
        return this.time;
    }

    @Nullable
    public final String getEnd_date() {
        return this.end_date;
    }

    @Nullable
    public final String getEnd_time() {
        return this.end_time;
    }

    @Nullable
    public final String getLinks() {
        return this.links;
    }

    @Nullable
    public final List<String> getLink_names() {
        return this.link_names;
    }

    @Nullable
    public final Boolean getVisible() {
        return this.visible;
    }

    @Nullable
    public final Integer getPriority() {
        return this.priority;
    }
}
